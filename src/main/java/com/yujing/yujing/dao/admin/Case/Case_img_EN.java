package com.yujing.yujing.dao.admin.Case;

import com.yujing.yujing.pojo.Case_imgPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Case_img_EN {
    public void insert_case_img(Case_imgPojo case_imgPojo);

    public List<Case_imgPojo> select_case_imglist(Integer sid);
}
