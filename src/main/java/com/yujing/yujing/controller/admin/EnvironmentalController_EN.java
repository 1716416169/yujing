package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Environmental;
import com.yujing.yujing.service.admin.EnvironmentalService;
import com.yujing.yujing.service.admin.EnvironmentalService_EN;
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
public class EnvironmentalController_EN {

    @Autowired
    private EnvironmentalService_EN environmentalService;

    @GetMapping(value = "/environmental_EN")
    public String introduce(){
        return "admin/introduce/environmental_EN";
    }

    @PostMapping(value = "/uploadenvironmental_EN")//上传图片
    @ResponseBody
    public Map<Object,Object> uploadenvironmental(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        Map<Object, Object> map = environmentalService.uploadenvironmental(file, multipartHttpServletRequest);
        return map;
    }

    @GetMapping(value = "/selectcountenvironmental_EN")
    @ResponseBody
    public int selectcountenvironmental(){
        return environmentalService.selectcountenvironmental();
    }

    @GetMapping(value = "/selectenvironmentallimit_EN")
    @ResponseBody
    public Map<Object,Object> selectenvironmentallimit(Integer a, Integer b){
        return environmentalService.selectenvironmentallimit(a , b);
    }
    @PostMapping(value = "/deleteenvironmental_EN")
    @ResponseBody
    public void deleteenvironmental(Environmental environmental){
        environmentalService.deleteenvironmental(environmental);
    }
    @PostMapping(value = "/deleteenvironmentals_EN")
    @ResponseBody
    public void deleteenvironmentals(@RequestBody List<Environmental> environmental){//将字符串转为json数据
        environmentalService.deleteenvironmentals(environmental);
    }
    @GetMapping(value = "/selectenvironmental_EN")
    @ResponseBody
    public Map<Object, Object> selectenvironmental(){
        return environmentalService.selectenvironmental();
    }
    @PostMapping(value = "/insertenvironmental_EN")
    @ResponseBody
    public void insertenvironmental(Environmental environmental){
        environmentalService.insertenvironmental(environmental);
    }
}
