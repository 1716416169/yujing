package com.yujing.yujing.service.user.Video;

import com.yujing.yujing.dao.admin.Introduce.Video;
import com.yujing.yujing.dao.user.Video.Search_video;
import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.VideoPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Value("${web.Allpath}")
    private String Allpath;
    @Autowired
    Search_video search_video;
    public Pagebean<VideoPojo> selectvideolimit(Integer page){
        Pagebean<VideoPojo> problemPagebean= new Pagebean<VideoPojo>();
        Integer pagecount;
        Integer number=9;
        Integer total = search_video.search_count_video();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<VideoPojo> videoPojos = search_video.search_video_limit((page - 1) * number, (page - 1) * number + number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(videoPojos);
        return problemPagebean;
    }
}
