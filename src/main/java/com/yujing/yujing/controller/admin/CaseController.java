package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Case.Case;
import com.yujing.yujing.dao.admin.Case.Case_img;
import com.yujing.yujing.dao.admin.Case.Case_type;
import com.yujing.yujing.pojo.*;
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
public class CaseController {

    @Autowired
    Case_type case_type;

    @Autowired
    Case ca;

    @Autowired
    Case_img case_img;

    @GetMapping(value = "/case")
    public String ca(){
        return "admin/case/case";
    }

    @ResponseBody
    @PostMapping(value = "/insert_case_type")
    public void insert_case_type(Case_typePojo case_typePojo){
        case_type.insert_case_type(case_typePojo);
        System.out.println("插入的案例类型是："+case_typePojo);
    }

    @GetMapping(value = "/select_case_type")
    @ResponseBody
    public Map<Object, Object> select_case_type(){
        List<Case_typePojo> case_typePojos = case_type.select_case_type();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",case_typePojos);
        System.out.println(case_typePojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_case_type")
    @ResponseBody
    public void delete_case_type(Case_typePojo case_typePojo){
        case_type.delete_case_type(case_typePojo);
        System.out.println("删除的类型是："+case_typePojo);
    }

    @PostMapping("/insert_case")
    @ResponseBody
    public void insert_case(CasePojo casePojo) {
        ca.insert_case(casePojo);
        ArrayList<String> pathList = AdminController.pathList;
        System.out.println("case:"+casePojo);
        if(AdminController.pathList!=null){
            for (String st:AdminController.pathList) {
                Case_imgPojo case_imgPojo = new Case_imgPojo();
                case_imgPojo.setCid(casePojo.getId());
                case_imgPojo.setPath(st);
                case_img.insert_case_img(case_imgPojo);
            }
        }
        AdminController.pathList=new ArrayList<>();
        System.out.println(casePojo);
    }

    @GetMapping(value = "/select_case")
    @ResponseBody
    public Map<Object, Object> select_case(){
        List<CasePojo> casePojos = ca.select_case();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",casePojos);
        return objectHashMap;
    }

    @PostMapping(value = "/delete_case")
    @ResponseBody
    public void delete_case(CasePojo casePojo){
        System.out.println(casePojo);
        List<Case_imgPojo> case_imgPojos = case_img.select_case_imglist(casePojo.getId());
        System.out.println(case_imgPojos);
        for (Case_imgPojo s:case_imgPojos) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(s.getPath());
        }
        ca.delete_case(casePojo);
        System.out.println(casePojo);
    }

    @PostMapping(value = "/delete_cases")
    @ResponseBody
    public void delete_cases(@RequestBody List<CasePojo> casePojo){
        for (CasePojo casePojo1: casePojo) {
            List<Case_imgPojo> case_imgPojos = case_img.select_case_imglist(casePojo1.getId());
            for (Case_imgPojo s:case_imgPojos) {
                Imgdelete imgdelete = new Imgdelete();
                imgdelete.deleteImg(s.getPath());
            }
        }
        ca.delete_cases(casePojo);
        System.out.println(casePojo);
    }


    @GetMapping(value = "/select_caselimit")
    @ResponseBody
    public Map<Object, Object> select_caselimit(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<CasePojo> casePojos = ca.select_caselimit(in1, in2);
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
    @GetMapping(value = "/select_count_case")
    public int select_count_case(){
        int i = ca.select_count_case();
        System.out.println("案例总数："+i);
        return i;
    }
}
