package com.yujing.yujing.dao.user.News;

import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.News_imgPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Search_news_EN {
    @Select("select * from news_EN where type={param1} limit #{param2},#{param3}")
    @Results({
            @Result(property = "news_imgPojos_EN",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.News.Search_news.search_news_imgs_imit_EN"))
    })
    public List<NewsPojo> search_news_limit_EN(int type, int page, int page1);//根据type查6条

    @Select("select * from news_EN where id={param1}")
    @Results({
            @Result(property = "news_imgPojos_EN",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.News.Search_news.search_news_imgs_imit_EN"))
    })
    public NewsPojo search_news_limit_ENbyid(int id);//根据type查6条

    @Select("select * from news_img_EN where nid=#{param1}")
    public List<News_imgPojo> search_news_imgs_limit_EN(int id);//查全部img

    @Select("select count(*) from news_EN")
    public Integer search_count_news_EN();
}
