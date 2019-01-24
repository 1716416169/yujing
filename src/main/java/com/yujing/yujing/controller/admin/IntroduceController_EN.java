package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Introduce;
import com.yujing.yujing.service.admin.IntroduceService;
import com.yujing.yujing.service.admin.IntroduceService_EN;
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
public class IntroduceController_EN {

    @Autowired
    private IntroduceService_EN introduceService;

    @GetMapping(value = "/introduce_EN")
    public String introduce(){
        return "admin/introduce/introduce_EN";
    }

    @PostMapping(value = "/uploadintroduce_EN")
    @ResponseBody
    public Map<Object,Object> uploadintroduce(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException{
        Map<Object, Object> map = introduceService.uploadintroduce(file, multipartHttpServletRequest);
        return map;
    }

    @GetMapping(value = "/selectcountintroduce_EN")
    @ResponseBody
    public int selectcountintroduce(){
        return introduceService.selectcountintroduce();
    }

    @GetMapping(value = "/selectintroducelimit_EN")
    @ResponseBody
    public Map<Object,Object> selectintroducelimit(Integer a, Integer b){
        return introduceService.selectintroducelimit(a , b);
    }
    @PostMapping(value = "/deleteintroduce_EN")
    @ResponseBody
    public void deleteintroduce(Introduce introduce){
        introduceService.deleteintroduce(introduce);
    }
    @PostMapping(value = "/deleteintroduces_EN")
    @ResponseBody
    public void deleteintroduces(@RequestBody List<Introduce> introduces){//将字符串转为json数据
        introduceService.deleteintroduces(introduces);
    }
    @GetMapping(value = "/selectintroduce_EN")
    @ResponseBody
    public Map<Object, Object> selectintroduce(){
        return introduceService.selectintroduce();
    }
    @PostMapping(value = "/insertintroduce_EN")
    @ResponseBody
    public void insertintroduce(Introduce introduce){
        introduceService.insertintroduce(introduce);
    }
}
