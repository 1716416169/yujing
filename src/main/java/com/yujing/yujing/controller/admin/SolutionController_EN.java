package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Solution.*;
import com.yujing.yujing.pojo.SolutionPojo;
import com.yujing.yujing.pojo.Solution_imgPojo;
import com.yujing.yujing.pojo.Solution_typePojo;
import com.yujing.yujing.tool.GetDate;
import com.yujing.yujing.tool.Imgdelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SolutionController_EN {

    @Autowired
    Solution_EN solution_EN;

    @Autowired
    Solution_img_EN solution_img_EN;

    @Autowired
    Solution_type_EN solution_type_EN;
    @GetMapping(value = "/solution_EN")
    public String solution_EN(){
        return "admin/solution/solution_EN";
    }

    @GetMapping(value = "/select_solution_EN")
    @ResponseBody
    public Map<Object, Object> select_solution_EN(){
        List<SolutionPojo> solutionPojos = solution_EN.select_solution();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",solutionPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/insert_solution_EN")
    @ResponseBody
    @Transactional
    public void insert_solution_EN(SolutionPojo solutionPojo){
        System.out.println("插入前："+solutionPojo);
        if(solutionPojo.getAdd_date()==""){
            solutionPojo.setAdd_date(new GetDate().Date());
        }
        solution_EN.insert_solution(solutionPojo);
        if(AdminController.pathList!=null){
            for (String st:AdminController.pathList) {
                Solution_imgPojo solution_imgPojo = new Solution_imgPojo();
                solution_imgPojo.setSid(solutionPojo.getId());
                solution_imgPojo.setPath(st);
                solution_img_EN.insert_solution_img(solution_imgPojo);
            }
        }
        AdminController.pathList=new ArrayList<>();
        System.out.println(solutionPojo);
    }

    @PostMapping(value = "/delete_solution_EN")
    @ResponseBody
    public void delete_solution_EN(SolutionPojo solutionPojo){
        List<Solution_imgPojo> solution_imgPojos = solution_img_EN.select_solution_imglist(solutionPojo.getId());
        for (Solution_imgPojo s:solution_imgPojos) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(s);
        }
        solution_EN.delete_solution(solutionPojo);
        System.out.println(solutionPojo);
    }

    @PostMapping(value = "/delete_solutions_EN")
    @ResponseBody
    public void delete_solutions_EN(@RequestBody List<SolutionPojo> solutionPojo){
        for (SolutionPojo solutionPojo1: solutionPojo) {
            List<Solution_imgPojo> solution_imgPojos = solution_img_EN.select_solution_imglist(solutionPojo1.getId());
            for (Solution_imgPojo s:solution_imgPojos) {
                Imgdelete imgdelete = new Imgdelete();
                imgdelete.deleteImg(s);
            }
        }
        solution_EN.delete_solutions(solutionPojo);
        System.out.println(solutionPojo);
    }


    @GetMapping(value = "/select_solutionlimit_EN")
    @ResponseBody
    public Map<Object, Object> select_solutionlimit_EN(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<SolutionPojo> solutionPojos = solution_EN.select_solutionlimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println(solutionPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",solutionPojos);
        return objectHashMap;
    }

    @ResponseBody
    @GetMapping(value = "/select_count_solution_EN")
    public int select_count_solution_EN(){
        int i = solution_EN.select_count_solution();
        System.out.println("解决方案总数："+i);
        return i;
    }

    @ResponseBody
    @GetMapping(value = "/select_solutiontype_EN")
    public Map<Object,Object> select_solutiontype_EN(){
        List<Solution_typePojo> solution_types = solution_type_EN.select_type();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",solution_types);
        return objectHashMap;
    }

}
