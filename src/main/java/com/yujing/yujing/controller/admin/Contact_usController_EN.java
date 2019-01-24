package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Contact_us.Contact_us_EN;
import com.yujing.yujing.pojo.Contact_usPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Contact_usController_EN {
    @Autowired
    Contact_us_EN contact_us_EN;

    @GetMapping(value = "/contact_us_EN")
    public String contact_us_EN(){
        return "admin/contact_us/contact_us_EN";
    }

    @GetMapping(value = "/select_contact_us_EN")
    @ResponseBody
    public Map<Object, Object> select_contact_us_EN(){
        List<Contact_usPojo> contact_usPojos = contact_us_EN.select_contact_us();
        System.out.println("留言信息有："+contact_usPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",contact_usPojos);
        return objectHashMap;
    }

    @ResponseBody
    @PostMapping(value = "/insert_contact_us_EN")
    public void insert_contact_us_EN(Contact_usPojo contact_usPojo){
        contact_us_EN.insert_contact_us();
        System.out.println("插入的留言："+contact_usPojo);
    }

    @ResponseBody
    @GetMapping(value = "/select_count_contact_us_EN")
    public int select_count_contact_us_EN(){
        int i = contact_us_EN.select_count_contact_us();
        System.out.println("解决方案总数："+i);
        return i;
    }

    @GetMapping(value = "/select_contact_uslimit_EN")
    @ResponseBody
    public Map<Object, Object> select_contact_uslimit_EN(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<Contact_usPojo> contact_usPojos = contact_us_EN.select_contact_uslimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println(contact_usPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",contact_usPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_contact_us_EN")
    @ResponseBody
    public void delete_contact_us_EN(Contact_usPojo contact_usPojo){
        contact_us_EN.delete_contact_us(contact_usPojo);
        System.out.println(contact_usPojo);
    }

    @PostMapping(value = "/delete_contact_uss_EN")
    @ResponseBody
    public void delete_contact_uss(@RequestBody List<Contact_usPojo> contact_usPojo){
        contact_us_EN.delete_contact_uss(contact_usPojo);
        System.out.println(contact_usPojo);
    }
}
