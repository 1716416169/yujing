package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Introduce.Seniority;
import com.yujing.yujing.dao.admin.Introduce.Seniority_EN;
import com.yujing.yujing.pojo.SeniorityPojo;
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
public class SeniorityController_EN {
    @Autowired
    Seniority_EN seniority_EN;

    @GetMapping(value = "/seniority_EN")
    public String seniority_EN(){
        return "admin/introduce/seniority_EN";
    }

    @PostMapping("/insert_seniority_EN")
    @ResponseBody
    public void insert_seniority_EN(SeniorityPojo seniorityPojo){
        ArrayList<String> pathList = AdminController.pathList;
        seniorityPojo.setPath(pathList.get(0));
        seniorityPojo.setType_name(5);
        System.out.println(seniorityPojo);
        seniority_EN.insert_seniority(seniorityPojo);
        AdminController.pathList=new ArrayList<>();
    }

    @GetMapping(value = "/select_seniority_EN")
    @ResponseBody
    public Map<Object, Object> select_seniority_EN(){
        List<SeniorityPojo> seniorityPojos = seniority_EN.select_seniority();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",seniorityPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_seniority_EN")
    @ResponseBody
    public void delete_seniority_EN(SeniorityPojo seniorityPojo){
        System.out.println(seniorityPojo);
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(seniorityPojo.getPath());
        seniority_EN.delete_seniority(seniorityPojo);
    }

    @PostMapping(value = "/delete_senioritys_EN")
    @ResponseBody
    public void delete_senioritys_EN(@RequestBody List<SeniorityPojo> seniorityPojo){
        for (SeniorityPojo v :seniorityPojo) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(v.getPath());
        }
        seniority_EN.delete_senioritys(seniorityPojo);
        System.out.println(seniorityPojo);
    }


    @GetMapping(value = "/select_senioritylimit_EN")
    @ResponseBody
    public Map<Object, Object> select_senioritylimit_EN(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<SeniorityPojo> seniorityPojos = seniority_EN.select_senioritylimit(in1, in2);
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
    @GetMapping(value = "/select_count_seniority_EN")
    public int select_count_seniority_EN(){
        int i = seniority_EN.select_count_seniority();
        System.out.println("资历总数："+i);
        return i;
    }
}
