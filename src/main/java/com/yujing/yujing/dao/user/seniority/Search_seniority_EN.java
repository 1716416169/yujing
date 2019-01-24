package com.yujing.yujing.dao.user.seniority;

import com.yujing.yujing.pojo.SeniorityPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Search_seniority_EN {

    @Select("select * from seniority_EN limit #{param1},#{param2}")
    public List<SeniorityPojo> search_seniority_limit_EN(int page, int page1);

    @Select("select count(*) from seniority_EN")
    public Integer search_count_seniority_EN();
}
