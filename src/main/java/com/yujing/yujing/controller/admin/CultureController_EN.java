package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Culture;
import com.yujing.yujing.service.admin.CultureService;
import com.yujing.yujing.service.admin.CultureService_EN;
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
public class CultureController_EN {

    @Autowired
    private CultureService_EN cultureService;

    @GetMapping(value = "/culture_EN")
    public String introduce(){
        return "admin/introduce/culture_EN";
    }

    @PostMapping(value = "/uploadculture_EN")
    @ResponseBody
    public Map<Object,Object> uploadculture(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException{
        Map<Object, Object> map = cultureService.uploadculture(file, multipartHttpServletRequest);
        return map;
    }

    @GetMapping(value = "/selectcountculture_EN")
    @ResponseBody
    public int selectcountculture(){
        return cultureService.selectcountculture();
    }

    @GetMapping(value = "/selectculturelimit_EN")
    @ResponseBody
    public Map<Object,Object> selectculturelimit(Integer a, Integer b){
        return cultureService.selectculturelimit(a , b);
    }
    @PostMapping(value = "/deleteculture_EN")
    @ResponseBody
    public void deleteintroduce(Culture culture){
        cultureService.deleteculture(culture);
    }
    @PostMapping(value = "/deletecultures_EN")
    @ResponseBody
    public void deletecultures(@RequestBody List<Culture> culture){//将字符串转为json数据
        cultureService.deletecultures(culture);
    }
    @GetMapping(value = "/selectculture_EN")
    @ResponseBody
    public Map<Object, Object> selectculture(){
        return cultureService.selectculture();
    }
    @PostMapping(value = "/insertculture_EN")
    @ResponseBody
    public void insertculture(Culture culture){
        cultureService.insertculture(culture);
    }
}
