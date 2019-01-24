package com.yujing.yujing.dao.admin.News;

import com.yujing.yujing.pojo.NewsPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface News_EN {
    public void insert_news(NewsPojo newsPojo);

    public List<NewsPojo> select_news();

    public void delete_news(NewsPojo newsPojo);

    public void delete_newss(List<NewsPojo> newsPojos);

    public List<NewsPojo> select_newslimit(Integer in1, Integer in2);

    public int select_count_news();
}
