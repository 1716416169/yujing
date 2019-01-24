package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.News.*;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.News_imgPojo;
import com.yujing.yujing.pojo.News_typePojo;
import com.yujing.yujing.tool.GetDate;
import com.yujing.yujing.tool.Imgdelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewsController_EN {
    @Autowired
    News_EN news_EN;

    @Autowired
    News_img_EN news_img_EN;

    @Autowired
    News_type_EN news_type_EN;
    @GetMapping(value = "/news_EN")
    public String news_EN(){
        return "admin/news/news_EN";
    }

    @GetMapping(value = "/select_news_EN")
    @ResponseBody
    public Map<Object, Object> select_news_EN(){
        List<NewsPojo> newsPojos = news_EN.select_news();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",newsPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/insert_news_EN")
    @ResponseBody
    //@Transactional
    public void insert_news_EN(NewsPojo newsPojo){
        System.out.println("插入前："+newsPojo);
        if(newsPojo.getAdd_date()==""){
            newsPojo.setAdd_date(new GetDate().Date());
        }
        news_EN.insert_news(newsPojo);
        System.out.println("news:"+newsPojo);
        if(AdminController.pathList!=null){
            for (String st:AdminController.pathList) {
                News_imgPojo news_imgPojo = new News_imgPojo();
                news_imgPojo.setNid(newsPojo.getId());
                news_imgPojo.setPath(st);
                news_img_EN.insert_news_img(news_imgPojo);
            }
        }
        AdminController.pathList=new ArrayList<>();
        System.out.println(newsPojo);
    }

    @PostMapping(value = "/delete_news_EN")
    @ResponseBody
    public void delete_news_EN(NewsPojo newsPojo){
        List<News_imgPojo> news_imgPojos = news_img_EN.select_news_imglist(newsPojo.getId());
        for (News_imgPojo s:news_imgPojos) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(s);
        }
        news_EN.delete_news(newsPojo);
        System.out.println(newsPojo);
    }

    @PostMapping(value = "/delete_newss_EN")
    @ResponseBody
    public void delete_newss_EN(@RequestBody List<NewsPojo> newsPojo){
        for (NewsPojo newsPojo1: newsPojo) {
            List<News_imgPojo> news_imgPojos = news_img_EN.select_news_imglist(newsPojo1.getId());
            for (News_imgPojo s:news_imgPojos) {
                Imgdelete imgdelete = new Imgdelete();
                imgdelete.deleteImg(s);
            }
        }
        news_EN.delete_newss(newsPojo);
        System.out.println(newsPojo);
    }


    @GetMapping(value = "/select_newslimit_EN")
    @ResponseBody
    public Map<Object, Object> select_newslimit_EN(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<NewsPojo> newsPojos = news_EN.select_newslimit(in1, in2);
        System.out.println(in1+" "+in2);
        System.out.println(newsPojos);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",newsPojos);
        return objectHashMap;
    }

    @ResponseBody
    @GetMapping(value = "/select_count_news_EN")
    public int select_count_news_EN(){
        int i = news_EN.select_count_news();
        System.out.println("新闻总数："+i);
        return i;
    }

    @ResponseBody
    @GetMapping(value = "/select_newstype_EN")
    public Map<Object,Object> select_newstype_EN(){
        List<News_typePojo> news_typePojos = news_type_EN.select_type();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",news_typePojos);
        return objectHashMap;
    }
}
