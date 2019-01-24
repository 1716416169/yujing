package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Solution.Solution;
import com.yujing.yujing.dao.admin.Solution.Solution_img;
import com.yujing.yujing.dao.admin.Solution.Solution_type;
import com.yujing.yujing.pojo.*;
import com.yujing.yujing.tool.GetDate;
import com.yujing.yujing.tool.Imgdelete;
import org.apache.ibatis.annotations.Param;
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
public class SolutionController {

    @Autowired
    Solution solution;

    @Autowired
    Solution_img solution_img;

    @Autowired
    Solution_type solution_type;
    @GetMapping(value = "/solution")
    public String solution(){
        return "admin/solution/solution";
    }

    @GetMapping(value = "/select_solution")
    @ResponseBody
    public Map<Object, Object> select_solution(){
        List<SolutionPojo> solutionPojos = solution.select_solution();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",solutionPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/insert_solution")
    @ResponseBody
    @Transactional
    public void insert_solution(SolutionPojo solutionPojo){
        System.out.println("插入前："+solutionPojo);
        if(solutionPojo.getAdd_date()==""){
            solutionPojo.setAdd_date(new GetDate().Date());
        }
        solution.insert_solution(solutionPojo);
        if(AdminController.pathList!=null){
            for (String st:AdminController.pathList) {
                Solution_imgPojo solution_imgPojo = new Solution_imgPojo();
                solution_imgPojo.setSid(solutionPojo.getId());
                solution_imgPojo.setPath(st);
                solution_img.insert_solution_img(solution_imgPojo);
            }
        }
        AdminController.pathList=new ArrayList<>();
        System.out.println(solutionPojo);
    }

    @PostMapping(value = "/delete_solution")
    @ResponseBody
    public void delete_solution(SolutionPojo solutionPojo){
        List<Solution_imgPojo> solution_imgPojos = solution_img.select_solution_imglist(solutionPojo.getId());
        for (Solution_imgPojo s:solution_imgPojos) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(s);
        }
        solution.delete_solution(solutionPojo);
        System.out.println(solutionPojo);
    }

    @PostMapping(value = "/delete_solutions")
    @ResponseBody
    public void delete_solutions(@RequestBody List<SolutionPojo> solutionPojo){
        for (SolutionPojo solutionPojo1: solutionPojo) {
            List<Solution_imgPojo> solution_imgPojos = solution_img.select_solution_imglist(solutionPojo1.getId());
            for (Solution_imgPojo s:solution_imgPojos) {
                Imgdelete imgdelete = new Imgdelete();
                imgdelete.deleteImg(s);
            }
        }
        solution.delete_solutions(solutionPojo);
        System.out.println(solutionPojo);
    }


    @GetMapping(value = "/select_solutionlimit")
    @ResponseBody
    public Map<Object, Object> select_solutionlimit(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<SolutionPojo> solutionPojos = solution.select_solutionlimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println("查询的数目"+solutionPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",solutionPojos);
        return objectHashMap;
    }

    @ResponseBody
    @GetMapping(value = "/select_count_solution")
    public int select_count_solution(){
        int i = solution.select_count_solution();
        System.out.println("解决方案总数："+i);
        return i;
    }

    @ResponseBody
    @GetMapping(value = "/select_solutiontype")
    public Map<Object,Object> select_solutiontype(){
        List<Solution_typePojo> solution_types = solution_type.select_type();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",solution_types);
        return objectHashMap;
    }

}
