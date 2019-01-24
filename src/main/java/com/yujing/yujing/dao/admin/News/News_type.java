package com.yujing.yujing.dao.admin.News;

import com.yujing.yujing.pojo.News_typePojo;
import com.yujing.yujing.pojo.Solution_typePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface News_type {
    public List<News_typePojo> select_type();
}
