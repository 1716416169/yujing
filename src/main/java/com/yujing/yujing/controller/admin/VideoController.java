package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Introduce.Video;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.News_imgPojo;
import com.yujing.yujing.pojo.VideoPojo;
import com.yujing.yujing.tool.GetDate;
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
public class VideoController {
    @Autowired
    Video video;

    @GetMapping("/video")
    public String video(){
        return "admin/introduce/video";
    }

    @PostMapping("/insert_video")
    @ResponseBody
    public void insert_video(VideoPojo videoPojo){
        ArrayList<String> pathList = AdminController.pathList;
        videoPojo.setPath(pathList.get(0));
        videoPojo.setType_name(5);
        System.out.println(videoPojo);
        video.insert_video(videoPojo);
        AdminController.pathList=new ArrayList<>();
    }

    @GetMapping(value = "/select_video")
    @ResponseBody
    public Map<Object, Object> select_video(){
        List<VideoPojo> videoPojos = video.select_video();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",videoPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_video")
    @ResponseBody
    public void delete_video(VideoPojo videoPojo){
        System.out.println(videoPojo);
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(videoPojo.getPath());
        video.delete_video(videoPojo);
    }

    @PostMapping(value = "/delete_videos")
    @ResponseBody
    public void delete_news(@RequestBody List<VideoPojo> videoPojo){
        for (VideoPojo v :videoPojo) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(v.getPath());
        }
        video.delete_videos(videoPojo);
        System.out.println(videoPojo);
    }


    @GetMapping(value = "/select_videolimit")
    @ResponseBody
    public Map<Object, Object> select_videolimit(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<VideoPojo> videoPojos = video.select_videolimit(in1, in2);
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
    @GetMapping(value = "/select_count_video")
    public int select_count_video(){
        int i = video.select_count_video();
        System.out.println("视频总数："+i);
        return i;
    }

}
