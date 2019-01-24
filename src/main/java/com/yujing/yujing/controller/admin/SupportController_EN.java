package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Support;
import com.yujing.yujing.service.admin.SupportService;
import com.yujing.yujing.service.admin.SupportService_EN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class SupportController_EN {

    @Autowired
    private SupportService_EN supportService;

    @GetMapping(value = "/support_EN")
    public String support(){
        return "admin/technical/support_EN";
    }

    @PostMapping(value = "/uploadsupport_EN")
    @ResponseBody
    public Map<Object,Object> uploadsupport(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException{
        Map<Object, Object> map = supportService.uploadsupport(file, multipartHttpServletRequest);
        return map;
    }

    @GetMapping(value = "/selectcountsupport_EN")
    @ResponseBody
    public int selectcountsupport(){
        return supportService.selectcountsupport();
    }

    @GetMapping(value = "/selectsupportlimit_EN")
    @ResponseBody
    public Map<Object,Object> selectsupportlimit(Integer a, Integer b){
        return supportService.selectsupportlimit(a , b);
    }
    @PostMapping(value = "/deletesupport_EN")
    @ResponseBody
    public void deletesupport(Support support){
        supportService.deletesupport(support);
    }
    @PostMapping(value = "/deletesupports_EN")
    @ResponseBody
    public void deletesupports(@RequestBody List<Support> supports){//将字符串转为json数据
        System.out.println(1);
        supportService.deletesupports(supports);
    }
    @GetMapping(value = "/selectsupport_EN")
    @ResponseBody
    public Map<Object, Object> selectsupport(){
        return supportService.selectsupport();
    }
    @PostMapping(value = "insertsupport_EN")
    @ResponseBody
    public void insertsupport(Support support){
        supportService.insertsupport(support);
    }
}
