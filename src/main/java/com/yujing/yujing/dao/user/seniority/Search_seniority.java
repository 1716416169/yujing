package com.yujing.yujing.dao.user.seniority;

import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.Case_imgPojo;
import com.yujing.yujing.pojo.SeniorityPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Search_seniority {

    @Select("select * from seniority limit #{param1},#{param2}")
    public List<SeniorityPojo> search_seniority_limit(Integer page, Integer page1);

    @Select("select count(*) from seniority")
    public Integer search_count_seniority();
}
