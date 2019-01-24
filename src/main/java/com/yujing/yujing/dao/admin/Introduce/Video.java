package com.yujing.yujing.dao.admin.Introduce;

import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.VideoPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Video {
    public void insert_video(VideoPojo videoPojo);

    public List<VideoPojo> select_videolimit(Integer in1, Integer in2);

    public int select_count_video();

    public void delete_video(VideoPojo videoPojo);

    public void delete_videos(List<VideoPojo> videoPojos);

    public List<VideoPojo> select_video();
}

