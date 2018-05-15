package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

/**
 * 搜索扩展参数ExtendedSearchParamList部分
 * Created by gmluo on 2018/5/2.
 */
public class SearchParamDTO {
    /**
     * 1.是否进行扩展搜索(0不需要扩展搜索，1 需要扩展搜索)
     * 2.搜索酒店城市对应产品（传城市ID）
     * 3.搜索酒店国家对应产品（传国家ID）
     * 5.搜索攻略目的地对应产品（传攻略目的地ID）。
     * 6.定位城市
     * 7.搜索酒店省份对应产品（传省份ID）
     * 9.定位城市（攻略目的地id）
     * 1005.是否需要补偿 0：不需要，1：需要（默认）
     * 1006.是否出附近产品 0：不需要（默认）1：需要
     * 1007. 是否需要提示语 0：不需要（默认）1 ：需要
     */
    public Integer type;

    public String value;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
