package com.yujing.yujing.controller.admin;

import com.yujing.yujing.tool.Imgupload;
import com.yujing.yujing.tool.Videoupload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController_EN {
    @Value("${web.Allpath}")
    private String Allpath;


    public static ArrayList<String> pathList_EN=new ArrayList<>();

    public static List<Map<Object,Object>> list_map_flow_EN = new ArrayList<>();

    @GetMapping(value = "/index_EN")
    public String index_EN(){
        return "admin/index_EN";
    }

    @PostMapping(value = "/upload_EN")
    @ResponseBody
    public Map<Object, Object> upload_EN(MultipartFile file) throws IOException {
        Imgupload imgupload = new Imgupload();
        Map<Object, Object> upload = imgupload.upload(file);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("errno",0);
        Object[] objects = new Object[2];
        objects[0]=Allpath+ File.separator +upload.get("src");
        map.put("data",objects);
        System.out.println(upload.get("src"));
        pathList_EN.add((String) upload.get("src"));
        System.out.println("上传的文件集合是："+pathList_EN);
        return map;
    }

    @PostMapping(value = "/uploadvideo_EN")
    @ResponseBody
    public Map<Object, Object> uploadvideo_EN(MultipartFile file) throws IOException {
        Videoupload videoupload = new Videoupload();
        Map<Object, Object> upload = videoupload.upload(file);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("errno",0);
        Object[] objects = new Object[2];
        objects[0]=Allpath+ File.separator +upload.get("src");
        map.put("data",objects);
        System.out.println(upload.get("src"));
        pathList_EN.add((String) upload.get("src"));
        System.out.println("上传的视频集合是："+pathList_EN);
        return map;
    }
}
