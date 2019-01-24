package com.yujing.yujing.dao.user.Video;

import com.yujing.yujing.pojo.VideoPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Search_video_EN {
    @Select("select * from video_EN limit #{param1},#{param2}")
    public List<VideoPojo> search_video_limit_EN(int page, int page1);

    @Select("select count(*) from video_EN")
    public Integer search_count_video_EN();
}
