package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

/**
 * 景点搜索排除参数类型ExceptList部分
 * Created by gmluo on 2018/5/2.
 */
public class ExceptParameter {
    /**
     * 1.产品类型ID，
     * 2.景点标签ID ,
     * 4.城市ID，
     * 5.省份ID，
     * 6.国家ID,
     * 7.大洲ID,
     * 8.GS目的地ID，
     * 9 所属地（省份，国家混合）,
     * 10 景点ID(注意加景区ID搜索)
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
