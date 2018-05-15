package cn.gmluo.searchapitest.searchservice.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取系统当前时间，并进行格式化
 * Created by gmluo on 2018/5/10.
 */
public class NowTime {
    public String getNowTime(){
        // 获取当前系统时间
        Date systemTime = new Date();
        // 设置时间格式化的样式
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH-mm:ss");
        // 对当前系统时间进行格式化
        String nowTime = format.format(systemTime);
        return nowTime;
    }
}
