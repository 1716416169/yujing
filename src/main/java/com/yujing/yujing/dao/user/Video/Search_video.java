package com.yujing.yujing.dao.user.Video;

import com.yujing.yujing.pojo.SeniorityPojo;
import com.yujing.yujing.pojo.VideoPojo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Search_video {
    @Select("select * from video limit #{param1},#{param2}")
    public List<VideoPojo> search_video_limit(int page, int page1);

    @Select("select count(*) from video")
    public Integer search_count_video();
}
