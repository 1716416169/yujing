package com.yujing.yujing.dao.admin.Solution;

import com.yujing.yujing.pojo.Solution_imgPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Solution_img {
    public void insert_solution_img(Solution_imgPojo solution_imgPojo);

    public List<Solution_imgPojo> select_solution_imglist(Integer sid);
}
