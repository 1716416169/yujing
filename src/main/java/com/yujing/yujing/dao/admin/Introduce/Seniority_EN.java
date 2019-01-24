package com.yujing.yujing.dao.admin.Introduce;

import com.yujing.yujing.pojo.SeniorityPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Seniority_EN {
    public void insert_seniority(SeniorityPojo seniorityPojo);

    public List<SeniorityPojo> select_senioritylimit(Integer in1, Integer in2);

    public int select_count_seniority();

    public void delete_seniority(SeniorityPojo seniorityPojo);

    public void delete_senioritys(List<SeniorityPojo> seniorityPojos);

    public List<SeniorityPojo> select_seniority();
}
