package com.yujing.yujing.controller.admin;

import com.sun.org.apache.xpath.internal.operations.Mult;
import com.yujing.yujing.dao.admin.Introduce.Seniority;
import com.yujing.yujing.dao.admin.Introduce.Video;
import com.yujing.yujing.pojo.SeniorityPojo;
import com.yujing.yujing.pojo.VideoPojo;
import com.yujing.yujing.tool.Imgdelete;
import com.yujing.yujing.tool.Imgupload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SeniorityController {

    @Autowired
    Seniority seniority;

    @GetMapping(value = "/seniority")
    public String seniority(){
        return "admin/introduce/seniority";
    }

    @PostMapping("/insert_seniority")
    @ResponseBody
    public void insert_seniority(SeniorityPojo seniorityPojo){
        ArrayList<String> pathList = AdminController.pathList;
        seniorityPojo.setPath(pathList.get(0));
        seniorityPojo.setType_name(5);
        System.out.println(seniorityPojo);
        seniority.insert_seniority(seniorityPojo);
        AdminController.pathList=new ArrayList<>();
    }

    @GetMapping(value = "/select_seniority")
    @ResponseBody
    public Map<Object, Object> select_seniority(){
        List<SeniorityPojo> seniorityPojos = seniority.select_seniority();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",seniorityPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_seniority")
    @ResponseBody
    public void delete_seniority(SeniorityPojo seniorityPojo){
        System.out.println(seniorityPojo);
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(seniorityPojo.getPath());
        seniority.delete_seniority(seniorityPojo);
    }

    @PostMapping(value = "/delete_senioritys")
    @ResponseBody
    public void delete_senioritys(@RequestBody List<SeniorityPojo> seniorityPojo){
        for (SeniorityPojo v :seniorityPojo) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(v.getPath());
        }
        seniority.delete_senioritys(seniorityPojo);
        System.out.println(seniorityPojo);
    }


    @GetMapping(value = "/select_senioritylimit")
    @ResponseBody
    public Map<Object, Object> select_senioritylimit(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<SeniorityPojo> seniorityPojos = seniority.select_senioritylimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println(seniorityPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",seniorityPojos);
        return objectHashMap;
    }

    @ResponseBody
    @GetMapping(value = "/select_count_seniority")
    public int select_count_seniority(){
        int i = seniority.select_count_seniority();
        System.out.println("资历总数："+i);
        return i;
    }

}
