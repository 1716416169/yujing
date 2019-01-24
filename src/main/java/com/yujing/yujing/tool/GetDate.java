package com.yujing.yujing.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public String Date(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        return df.format(new Date());
    }
}
