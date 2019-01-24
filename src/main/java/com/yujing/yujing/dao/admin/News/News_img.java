package com.yujing.yujing.dao.admin.News;

import com.yujing.yujing.pojo.News_imgPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface News_img {
    public void insert_news_img(News_imgPojo news_imgPojo);

    public List<News_imgPojo> select_news_imglist(Integer sid);
}
