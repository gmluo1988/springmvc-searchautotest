package cn.gmluo.searchapitest.searchservice.dao.impl;


import cn.gmluo.searchapitest.getresponse.requesttype.intervention.GetMarchResultType;
import cn.gmluo.searchapitest.searchservice.dao.InterventionDao;
import cn.gmluo.searchapitest.searchservice.entity.Intervention;
import cn.gmluo.searchapitest.searchservice.util.NowTime;
import cn.gmluo.searchapitest.searchservice.util.PageBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 2.数据访问层（持久层）
 * 2.1-dao接口方法实现类
 * Created by gmluo on 2018/5/10.
 */
@Repository("interventionDaoImpl")
public class InterventionDaoImpl implements InterventionDao {
    //IOC容器注入对象jdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private NowTime nowTime = new NowTime();

    /**
     * 插入人工干预排序对比结果方法实现
     *
     * @param intervention
     */
    @Override
    public void insertResult(Intervention intervention) {
        String sql = "INSERT INTO intervention (SearchType, DistrictId, ProductId, SortOrder, SearchApiOrder, Tuiguang, ApiReturn, March, TestStatus, TestDate)VALUES (?,?,?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql,
                intervention.getSearchType(), intervention.getDistrictId(), intervention.getProductId(),
                intervention.getSortOrder(), intervention.getSearchApiOrder(),
                intervention.getTuiguang(), intervention.getApiReturn(),
                intervention.getMarch(), intervention.getTestStatus(), nowTime.getNowTime());
    }

    /**
     * 根据条件查询排序对比详情方法实现
     * @param pageBean
     * @param resultType
     */
    @Override
    public void filterFindMatchResult(PageBean<Intervention> pageBean, GetMarchResultType resultType) {
        Integer searchType=resultType.getSearchType();
        Integer testStatus=resultType.getTestStatus();
        Integer pageIndex = resultType.getPageIndex();
        Integer pageSize = resultType.getPageSize();
        int totalCount = -1;

        // 1.设置当前页码
        pageBean.setCurrentPage(pageIndex);

        // 2.设置每页返回的数据数目
        pageBean.setPageCount(pageSize);

        // 3.1查询总结果数;设置到pageBean对象中
        //如果传入了testStatus,即走按testStatus筛选查询,没有即走按searchType查询总数
        totalCount=this.getTotalCountByTestStatus(searchType,testStatus);

        //3.2如果总条数小于等于0
        if (totalCount <= 0) {
            pageBean.setTotalCount(0);
            pageBean.setTotalPage(0);
            pageBean.setPageData(null);
        } else {
            //3.3设置结果总条数
            pageBean.setTotalCount(totalCount);

            // 4.判断前端传入的当前页值
            // 4.1如果前端传入的当前页值<=0;则需将当前页赋值为1（即第一页）
            if (pageBean.getCurrentPage() <= 0) {
                pageBean.setCurrentPage(1);// 将当前页赋值为第一页
            }
            // 4.2如果前端传入的当前页值大于最大页的值
            else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
                pageBean.setCurrentPage(pageBean.getTotalPage());// 将当前页赋值为最大页的值
            }

            // 5. 获取当前页数，计算当前页数据查询sql需要的起始行和放回的行数
            int currentPage = pageBean.getCurrentPage();// 获取此时pageBean中的当前页值
            int index = (currentPage - 1) * pageBean.getPageCount();// 计算出sql查询语句中的起始值
            int count = pageBean.getPageCount();// 获取需要返回的数据行数

            //如果没有传入TestStatus或者testStatus==0,即走分页查询
            if (testStatus==null||testStatus==0){
                String sql = "SELECT * FROM intervention WHERE SearchType=? ORDER BY DistrictId LIMIT ?,?;";
                List<Intervention> interventionList = jdbcTemplate.query(sql, new MyResult(), searchType, index, count);
                pageBean.setPageData(interventionList);
            }
            //如果传入了TestStatus，即走按testStatus筛选查询
            else {
                String sql = "SELECT * FROM intervention WHERE SearchType=? AND TestStatus=? ORDER BY DistrictId LIMIT ?,?;";
                List<Intervention> interventionList = jdbcTemplate.query(sql, new MyResult(), searchType, testStatus,index, count);
                pageBean.setPageData(interventionList);
            }
        }
    }


    /**
     * 根据searchType、testStatus查询总记录数方法
     * @param searchType
     * @param testStatus
     * @return
     */
    public int getTotalCountByTestStatus(Integer searchType,Integer testStatus) {
        int totalCount=0;
        //如果没有传入了testStatus或者testStatus==0,即走按searchType查询
        if (testStatus==null||testStatus==0){
            String sql = "SELECT count(*) FROM intervention WHERE SearchType=? ORDER BY DistrictId;";
            totalCount=jdbcTemplate.queryForObject(sql,Integer.class,searchType);
        }else {
            //如果传入了testStatus,即走按testStatus筛选查询,
            String sql = "SELECT count(*) FROM intervention WHERE SearchType=? AND TestStatus=? ORDER BY DistrictId;";
            totalCount=jdbcTemplate.queryForObject(sql,Integer.class,searchType,testStatus);
        }
        return totalCount;
    }

    /**
     * 封装方法1
     */
    class MyResult implements RowMapper<Intervention> {
        // 如何封装一行记录
        public Intervention mapRow(ResultSet rs, int index) throws SQLException {
            Intervention intervention = new Intervention();
            intervention.setId(rs.getInt("id"));
            intervention.setSearchType(rs.getInt("searchType"));
            intervention.setDistrictId(rs.getInt("districtId"));
            intervention.setProductId(rs.getLong("productId"));
            intervention.setSortOrder(rs.getInt("sortOrder"));
            intervention.setSearchApiOrder(rs.getInt("searchApiOrder"));
            intervention.setTuiguang(rs.getBoolean("tuiguang"));
            intervention.setApiReturn(rs.getBoolean("apiReturn"));
            intervention.setMarch(rs.getBoolean("march"));
            intervention.setTestStatus(rs.getInt("testStatus"));
            intervention.setTestDate(rs.getDate("testDate"));

            return intervention;
        }
    }
}
