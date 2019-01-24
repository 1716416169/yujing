package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Environmental;
import com.yujing.yujing.service.admin.EnvironmentalService;
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
public class EnvironmentalController {

    @Autowired
    private EnvironmentalService environmentalService;

    @GetMapping(value = "/environmental")
    public String introduce(){
        return "admin/introduce/environmental";
    }

    @PostMapping(value = "/uploadenvironmental")//上传图片
    @ResponseBody
    public Map<Object,Object> uploadenvironmental(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        Map<Object, Object> map = environmentalService.uploadenvironmental(file, multipartHttpServletRequest);
        return map;
    }

    @GetMapping(value = "/selectcountenvironmental")
    @ResponseBody
    public int selectcountenvironmental(){
        return environmentalService.selectcountenvironmental();
    }

    @GetMapping(value = "/selectenvironmentallimit")
    @ResponseBody
    public Map<Object,Object> selectenvironmentallimit(Integer a, Integer b){
        return environmentalService.selectenvironmentallimit(a , b);
    }
    @PostMapping(value = "/deleteenvironmental")
    @ResponseBody
    public void deleteenvironmental(Environmental environmental){
        environmentalService.deleteenvironmental(environmental);
    }
    @PostMapping(value = "/deleteenvironmentals")
    @ResponseBody
    public void deleteenvironmentals(@RequestBody List<Environmental> environmental){//将字符串转为json数据
        environmentalService.deleteenvironmentals(environmental);
    }
    @GetMapping(value = "/selectenvironmental")
    @ResponseBody
    public Map<Object, Object> selectenvironmental(){
        return environmentalService.selectenvironmental();
    }
    @PostMapping(value = "/insertenvironmental")
    @ResponseBody
    public void insertenvironmental(Environmental environmental){
        environmentalService.insertenvironmental(environmental);
    }
}
