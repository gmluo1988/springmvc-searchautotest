package cn.gmluo.searchapitest.searchservice.service;


import cn.gmluo.searchapitest.getresponse.requesttype.intervention.GetMarchResultType;
import cn.gmluo.searchapitest.searchservice.entity.Intervention;
import cn.gmluo.searchapitest.searchservice.util.PageBean;

/**
 * 3.业务逻辑层
 * 3.1-service接口设计
 * Created by gmluo on 2018/5/10.
 */
public interface InterventionService {

    /**
     * 插入人工干预排序对比结果方法
     * @param intervention
     */
    public void insertResult(Intervention intervention);

    /**
     * 根据条件查询排序对比详情方法
     * 根据searchType获取对应列表页的对比详情,再根据testStatus进行筛选查询方法
     * @param pageBean
     * @param resultType
     */
    public void filterFindMatchResult(PageBean<Intervention> pageBean, GetMarchResultType resultType);
}
