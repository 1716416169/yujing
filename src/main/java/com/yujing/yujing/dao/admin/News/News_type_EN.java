package com.yujing.yujing.dao.admin.News;

import com.yujing.yujing.pojo.News_typePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface News_type_EN {
    public List<News_typePojo> select_type();
}
