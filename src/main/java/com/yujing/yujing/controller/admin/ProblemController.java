package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Problem;
import com.yujing.yujing.service.admin.ProblemService;
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
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping(value = "/problem")
    public String getproblem(){
        return "admin/technical/problem";
    }
    @PostMapping(value = "/insertproblem")
    @ResponseBody
    public void insertproblem(Problem problem){
        System.out.println(problem.getText()+","+problem.getTitle());
        problemService.insertproblem(problem);
    }
    @ResponseBody
    @PostMapping(value = "/deleteproblem")
    public void deleteproblem(Problem problem){
        problemService.deleteproblem(problem);
    }
    @ResponseBody
    @GetMapping(value = "/selectcountproblem")
    public int selectcountproblem(){
        int i = problemService.selectcountproblem();
        return i;
    }
    @GetMapping(value = "/selectproblemlimit")
    @ResponseBody
    public Map<Object, Object> selectproblemlimit(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<Problem> solutionPojos = problemService.selectproblemlimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println(solutionPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",solutionPojos);
        return objectHashMap;
    }
    @GetMapping(value = "/selectproblem")
    @ResponseBody
    public Map<Object, Object> selectproblem(){
        List<Problem> solutionPojos = problemService.selectproblem();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",solutionPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/deleteproblems")
    @ResponseBody
    public void deleteproblems(@RequestBody List<Problem> problems){
        problemService.deleteproblems(problems);
    }
}
