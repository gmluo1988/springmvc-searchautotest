package cn.gmluo.searchapitest.searchservice.service.impl;


import cn.gmluo.searchapitest.getresponse.requesttype.intervention.GetMarchResultType;
import cn.gmluo.searchapitest.searchservice.dao.InterventionDao;
import cn.gmluo.searchapitest.searchservice.entity.Intervention;
import cn.gmluo.searchapitest.searchservice.service.InterventionService;
import cn.gmluo.searchapitest.searchservice.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 3.业务逻辑层
 * 3.2-service接口实现类
 * Created by gmluo on 2018/5/10.
 */
@Service("interventionServiceImpl")
public class InterventionServiceImpl implements InterventionService {
    @Resource(name = "interventionDaoImpl")
    private InterventionDao interventionDao;
    /**
     * 插入人工干预排序对比结果方法
     * @param intervention
     */
    @Override
    public void insertResult(Intervention intervention) {
        interventionDao.insertResult(intervention);
    }

    /**
     * 根据条件查询排序对比详情方法实现
     * 根据searchType获取对应列表页的对比详情,再根据testStatus进行筛选查询方法
     * @param pageBean
     * @param resultType
     */
    @Override
    public void filterFindMatchResult(PageBean<Intervention> pageBean, GetMarchResultType resultType) {
        interventionDao.filterFindMatchResult(pageBean,resultType);
    }
}
