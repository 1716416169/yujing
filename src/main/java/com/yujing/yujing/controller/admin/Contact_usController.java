package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Contact_us.Contact_us;
import com.yujing.yujing.pojo.Contact_usPojo;
import com.yujing.yujing.pojo.SolutionPojo;
import com.yujing.yujing.pojo.Solution_imgPojo;
import com.yujing.yujing.tool.Imgdelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.nio.cs.ext.MacArabic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Contact_usController {
    @Autowired
    Contact_us contact_us;

    @GetMapping(value = "/contact_us")
    public String contact_us(){
        return "admin/contact_us/contact_us";
    }

    @GetMapping(value = "/select_contact_us")
    @ResponseBody
    public Map<Object, Object> select_contact_us(){
        List<Contact_usPojo> contact_usPojos = contact_us.select_contact_us();
        System.out.println("留言信息有："+contact_usPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",contact_usPojos);
        return objectHashMap;
    }

    @ResponseBody
    @PostMapping(value = "/insert_contact_us")
    public void insert_contact_us(Contact_usPojo contact_usPojo){
        contact_us.insert_contact_us();
        System.out.println("插入的留言："+contact_usPojo);
    }

    @ResponseBody
    @GetMapping(value = "/select_count_contact_us")
    public int select_count_contact_us(){
        int i = contact_us.select_count_contact_us();
        System.out.println("解决方案总数："+i);
        return i;
    }

    @GetMapping(value = "/select_contact_uslimit")
    @ResponseBody
    public Map<Object, Object> select_contact_uslimit(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<Contact_usPojo> contact_usPojos = contact_us.select_contact_uslimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println(contact_usPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",contact_usPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_contact_us")
    @ResponseBody
    public void delete_contact_us(Contact_usPojo contact_usPojo){
        contact_us.delete_contact_us(contact_usPojo);
        System.out.println(contact_usPojo);
    }

    @PostMapping(value = "/delete_contact_uss")
    @ResponseBody
    public void delete_contact_uss(@RequestBody List<Contact_usPojo> contact_usPojo){
        contact_us.delete_contact_uss(contact_usPojo);
        System.out.println(contact_usPojo);
    }
}
