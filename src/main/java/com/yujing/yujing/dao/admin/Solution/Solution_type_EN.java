package com.yujing.yujing.dao.admin.Solution;

import com.yujing.yujing.pojo.Solution_typePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Solution_type_EN {
    public List<Solution_typePojo> select_type();
}
