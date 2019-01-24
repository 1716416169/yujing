package com.yujing.yujing.controller.admin;


import com.yujing.yujing.tool.Flowupload;
import com.yujing.yujing.tool.Imgupload;
import com.yujing.yujing.tool.Videoupload;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Value("${web.Allpath}")
    private String Allpath;


    public static ArrayList<String> pathList=new ArrayList<>();

    public static List<Map<Object,Object>> list_map_flow = new ArrayList<>();

    @GetMapping(value = "/index")
    public String index(){
        return "admin/index";
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public Map<Object, Object> upload(MultipartFile file) throws IOException {
        Imgupload imgupload = new Imgupload();
        Map<Object, Object> upload = imgupload.upload(file);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("errno",0);
        Object[] objects = new Object[2];
        objects[0]=Allpath+ File.separator +upload.get("src");
        map.put("data",objects);
        System.out.println(upload.get("src"));
        pathList.add((String) upload.get("src"));
        System.out.println("上传的文件集合是："+pathList);
        return map;
    }

    @PostMapping(value = "/uploadvideo")
    @ResponseBody
    public Map<Object, Object> uploadvideo(MultipartFile file) throws IOException {
        Videoupload videoupload = new Videoupload();
        Map<Object, Object> upload = videoupload.upload(file);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("errno",0);
        Object[] objects = new Object[2];
        objects[0]=Allpath+ File.separator +upload.get("src");
        map.put("data",objects);
        System.out.println(upload.get("src"));
        pathList.add((String) upload.get("src"));
        System.out.println("上传的视频集合是："+pathList);
        return map;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////



}
