package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Introduce.Video;
import com.yujing.yujing.dao.admin.Introduce.Video_EN;
import com.yujing.yujing.pojo.VideoPojo;
import com.yujing.yujing.tool.Imgdelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController_EN {
    @Autowired
    Video_EN video_EN;

    @GetMapping("/video_EN")
    public String video_EN(){
        return "admin/introduce/video_EN";
    }

    @PostMapping("/insert_video_EN")
    @ResponseBody
    public void insert_video_EN(VideoPojo videoPojo){
        ArrayList<String> pathList = AdminController.pathList;
        videoPojo.setPath(pathList.get(0));
        videoPojo.setType_name(5);
        System.out.println(videoPojo);
        video_EN.insert_video(videoPojo);
        AdminController.pathList=new ArrayList<>();
    }

    @GetMapping(value = "/select_video_EN")
    @ResponseBody
    public Map<Object, Object> select_video_EN(){
        List<VideoPojo> videoPojos = video_EN.select_video();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",videoPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_video_EN")
    @ResponseBody
    public void delete_video_EN(VideoPojo videoPojo){
        System.out.println(videoPojo);
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(videoPojo.getPath());
        video_EN.delete_video(videoPojo);
    }

    @PostMapping(value = "/delete_videos_EN")
    @ResponseBody
    public void delete_news_EN(@RequestBody List<VideoPojo> videoPojo){
        for (VideoPojo v :videoPojo) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(v.getPath());
        }
        video_EN.delete_videos(videoPojo);
        System.out.println(videoPojo);
    }


    @GetMapping(value = "/select_videolimit_EN")
    @ResponseBody
    public Map<Object, Object> select_videolimit_EN(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<VideoPojo> videoPojos = video_EN.select_videolimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println(videoPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",videoPojos);
        return objectHashMap;
    }

    @ResponseBody
    @GetMapping(value = "/select_count_video_EN")
    public int select_count_video_EN(){
        int i = video_EN.select_count_video();
        System.out.println("视频总数："+i);
        return i;
    }

}
