package com.yujing.yujing.service.user.Video;

import com.yujing.yujing.dao.user.Video.Search_video;
import com.yujing.yujing.dao.user.Video.Search_video_EN;
import com.yujing.yujing.pojo.VideoPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService_EN {
    Search_video_EN search_video_EN;
    public Pagebean<VideoPojo> selectvideolimit_EN(Integer page, Integer number){
        Pagebean<VideoPojo> problemPagebean= new Pagebean<VideoPojo>();
        Integer pagecount;
        Integer total = search_video_EN.search_count_video_EN();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<VideoPojo> videoPojos = search_video_EN.search_video_limit_EN((pagecount - 1) * number, (pagecount - 1) * number + number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(videoPojos);
        return problemPagebean;
    }
}
