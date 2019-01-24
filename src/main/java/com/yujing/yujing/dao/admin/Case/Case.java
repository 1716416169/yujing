package com.yujing.yujing.dao.admin.Case;

import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.SeniorityPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Case {
    public void insert_case(CasePojo casePojo);

    public List<CasePojo> select_caselimit(Integer in1, Integer in2);

    public int select_count_case();

    public void delete_case(CasePojo casePojo);

    public void delete_cases(List<CasePojo> casePojos);

    public List<CasePojo> select_case();
}
