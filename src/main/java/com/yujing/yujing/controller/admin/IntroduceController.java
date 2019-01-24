package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Introduce;
import com.yujing.yujing.service.admin.IntroduceService;
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
public class IntroduceController {

    @Autowired
    private IntroduceService introduceService;

    @GetMapping(value = "/introduce")
    public String introduce(){
        return "admin/introduce/introduce";
    }

    @PostMapping(value = "/uploadintroduce")
    @ResponseBody
    public Map<Object,Object> uploadintroduce(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException{
        Map<Object, Object> map = introduceService.uploadintroduce(file, multipartHttpServletRequest);
        return map;
    }

    @GetMapping(value = "/selectcountintroduce")
    @ResponseBody
    public int selectcountintroduce(){
        return introduceService.selectcountintroduce();
    }

    @GetMapping(value = "/selectintroducelimit")
    @ResponseBody
    public Map<Object,Object> selectintroducelimit(Integer a, Integer b){
        return introduceService.selectintroducelimit(a , b);
    }
    @PostMapping(value = "/deleteintroduce")
    @ResponseBody
    public void deleteintroduce(Introduce introduce){
        introduceService.deleteintroduce(introduce);
    }
    @PostMapping(value = "/deleteintroduces")
    @ResponseBody
    public void deleteintroduces(@RequestBody List<Introduce> introduces){//将字符串转为json数据
        introduceService.deleteintroduces(introduces);
    }
    @GetMapping(value = "/selectintroduce")
    @ResponseBody
    public Map<Object, Object> selectintroduce(){
        return introduceService.selectintroduce();
    }
    @PostMapping(value = "/insertintroduce")
    @ResponseBody
    public void insertintroduce(Introduce introduce){
        introduceService.insertintroduce(introduce);
    }
}
