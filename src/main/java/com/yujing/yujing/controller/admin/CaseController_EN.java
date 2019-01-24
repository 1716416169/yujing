package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Case.*;
import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.Case_imgPojo;
import com.yujing.yujing.pojo.Case_typePojo;
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
public class CaseController_EN {

    @Autowired
    Case_type_EN case_type_EN;

    @Autowired
    Case_EN ca_EN;

    @Autowired
    Case_img_EN case_img_EN;

    @GetMapping(value = "/case_EN")
    public String ca_EN(){
        return "admin/case/case_EN";
    }

    @ResponseBody
    @PostMapping(value = "/insert_case_type_EN")
    public void insert_case_type_EN(Case_typePojo case_typePojo){
        case_type_EN.insert_case_type(case_typePojo);
        System.out.println("插入的案例类型是："+case_typePojo);
    }

    @GetMapping(value = "/select_case_type_EN")
    @ResponseBody
    public Map<Object, Object> select_case_type_EN(){
        List<Case_typePojo> case_typePojos = case_type_EN.select_case_type();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",case_typePojos);
        System.out.println(case_typePojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_case_type_EN")
    @ResponseBody
    public void delete_case_type_EN(Case_typePojo case_typePojo){
        case_type_EN.delete_case_type(case_typePojo);
        System.out.println("删除的类型是："+case_typePojo);
    }

    @PostMapping("/insert_case_EN")
    @ResponseBody
    public void insert_case_EN(CasePojo casePojo) {
        ca_EN.insert_case(casePojo);
        ArrayList<String> pathList = AdminController.pathList;
        System.out.println("case:"+casePojo);
        if(AdminController.pathList!=null){
            for (String st:AdminController.pathList) {
                Case_imgPojo case_imgPojo = new Case_imgPojo();
                case_imgPojo.setCid(casePojo.getId());
                case_imgPojo.setPath(st);
                case_img_EN.insert_case_img(case_imgPojo);
            }
        }
        AdminController.pathList=new ArrayList<>();
        System.out.println(casePojo);
    }

    @GetMapping(value = "/select_case_EN")
    @ResponseBody
    public Map<Object, Object> select_case_EN(){
        List<CasePojo> casePojos = ca_EN.select_case();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",casePojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_case_EN")
    @ResponseBody
    public void delete_case_EN(CasePojo casePojo){
        System.out.println(casePojo);
        List<Case_imgPojo> case_imgPojos = case_img_EN.select_case_imglist(casePojo.getId());
        System.out.println(case_imgPojos);
        for (Case_imgPojo s:case_imgPojos) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(s.getPath());
        }
        ca_EN.delete_case(casePojo);
        System.out.println(casePojo);
    }

    @PostMapping(value = "/delete_cases_EN")
    @ResponseBody
    public void delete_cases_EN(@RequestBody List<CasePojo> casePojo){
        for (CasePojo casePojo1: casePojo) {
            List<Case_imgPojo> case_imgPojos = case_img_EN.select_case_imglist(casePojo1.getId());
            for (Case_imgPojo s:case_imgPojos) {
                Imgdelete imgdelete = new Imgdelete();
                imgdelete.deleteImg(s.getPath());
            }
        }
        ca_EN.delete_cases(casePojo);
        System.out.println(casePojo);
    }


    @GetMapping(value = "/select_caselimit_EN")
    @ResponseBody
    public Map<Object, Object> select_caselimit_EN(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<CasePojo> casePojos = ca_EN.select_caselimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println(casePojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",casePojos);
        return objectHashMap;
    }

    @ResponseBody
    @GetMapping(value = "/select_count_case_EN")
    public int select_count_case_EN(){
        int i = ca_EN.select_count_case();
        System.out.println("案例总数："+i);
        return i;
    }
}
