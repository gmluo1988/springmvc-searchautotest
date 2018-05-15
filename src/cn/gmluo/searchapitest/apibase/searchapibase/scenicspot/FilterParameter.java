package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

/**
 * 景点搜索过滤参数类型FilterList部分
 * Created by gmluo on 2018/5/2.
 */
public class FilterParameter {
    /**
     * 1.产品类型ID，
     * 2.景点标签ID ,
     * 4.城市ID，
     * 5.省份ID，
     * 6.国家ID,
     * 7.大洲ID,
     * 8.GS目的地ID(注意加景区ID搜索)，
     * 9所属地（省份，国家混合）,
     * 10,周边搜索时的城市 ,
     * 11攻略POI主题ID,
     * 12,人工干预
     * 13.产品来源(0:售卖景点，1：非售卖景点，2：纯门票景点)
     * 26.快筛标签（9：今日可用，10：明日可用）
     * 注意：Type 中同类型多条件查询时是or的关系。另外类型与类型之间，组与组之间是and的关系，组内类型之间是or的关系
     */
    String type;
    String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
