package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Flow;
import com.yujing.yujing.service.admin.FlowService;
import com.yujing.yujing.service.admin.FlowService_EN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

@Controller
public class FlowController_EN {

    @Autowired
    private FlowService_EN flowService;

    @GetMapping(value = "/flow_EN")
    public String flow(){
        return "admin/technical/flow_EN";
    }

    @PostMapping(value = "/uploadflow_EN")//上传图片
    @ResponseBody
    public Map<Object,Object> uploadflow(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        Map<Object, Object> map = flowService.uploadflow(file, multipartHttpServletRequest);
        return map;
    }

    @GetMapping(value = "/selectcountflow_EN")
    @ResponseBody
    public int selectcountflow(){
        return flowService.selectcountflow();
    }

    @GetMapping(value = "/selectflowlimit_EN")
    @ResponseBody
    public Map<Object,Object> selectflowlimit(Integer a, Integer b){
        return flowService.selectflowlimit(a , b);
    }
    @PostMapping(value = "/deleteflow_EN")
    @ResponseBody
    public void deleteflow(Flow flow){
        flowService.deleteflow(flow);
    }
    @PostMapping(value = "/deleteflows_EN")
    @ResponseBody
    public void deleteflows(@RequestBody List<Flow> flow){//将字符串转为json数据
        flowService.deleteflows(flow);
    }
    @GetMapping(value = "/selectflow_EN")
    @ResponseBody
    public Map<Object, Object> selectflow(){
        return flowService.selectflow();
    }
    @PostMapping(value = "/insertflow_EN")
    @ResponseBody
    public void insertflow(Flow flow){
        flowService.insertflow(flow);
    }
}
