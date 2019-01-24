package com.yujing.yujing.dao.user.News;

import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.Case_imgPojo;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.News_imgPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Search_news {
    @Select("select *,id idd from news where type=#{p1} limit #{p2},#{p3}")
    @Results({
            @Result(property = "id",column = "idd"),
            @Result(property = "news_imgPojos",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.News.Search_news.search_news_imgs_limit"))
    })
    public List<NewsPojo> search_news_limit(@Param("p1") Integer type, @Param("p2")Integer page, @Param("p3")Integer page1);//根据type查6条


    @Select("select *,id idd from news where id=#{p1}")
    @Results({
            @Result(property = "id",column = "idd"),
            @Result(property = "news_imgPojos",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.News.Search_news.search_news_imgs_limit"))
    })
    public NewsPojo search_news_limitById(@Param("p1")Integer id);//根据type查6条

    @Select("select * from news_img where nid=#{param1}")
    public News_imgPojo search_news_imgs_limit(int id);//查全部img

    @Select("select count(*) from news")
    public Integer search_count_news();

    @Select("select *,id idd from news where type=#{param1}")
    @Results({
            @Result(property = "id",column = "idd"),
            @Result(property = "news_imgPojos",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.News.Search_news.search_news_imgs_limit"))
    })
    public List<NewsPojo> search_newsbytype(Integer type);

}
