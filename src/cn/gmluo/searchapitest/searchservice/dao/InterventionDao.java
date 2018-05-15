package cn.gmluo.searchapitest.searchservice.dao;


import cn.gmluo.searchapitest.getresponse.requesttype.intervention.GetMarchResultType;
import cn.gmluo.searchapitest.searchservice.entity.Intervention;
import cn.gmluo.searchapitest.searchservice.util.PageBean;

/**
 * 2.数据访问层（持久层）
 * 2.1-dao接口设计
 * Created by gmluo on 2018/5/10.
 */
public interface InterventionDao {

    /**
     * 插入人工干预排序对比结果方法
     *
     * @param intervention
     */
    public void insertResult(Intervention intervention);

//    /**
//     * 根据searchType获取对应列表页的对比详情方法
//     *
//     * @param searchType
//     * @return
//     */
//    public PageBean<Intervention> findMatchResult(int searchType);

    /**
     * 根据条件查询排序对比详情方法
     * 根据searchType获取对应列表页的对比详情,再根据testStatus进行筛选查询方法
     * @param pageBean
     * @param resultType
     */
    public void filterFindMatchResult(PageBean<Intervention> pageBean, GetMarchResultType resultType);

}
