package com.yujing.yujing.dao.admin.Case;

import com.yujing.yujing.pojo.Case_typePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Case_type {

    public List<Case_typePojo> select_case_type();

    public void insert_case_type(Case_typePojo case_typePojo);

    public Case_typePojo delete_case_type(Case_typePojo case_typePojo);
}
