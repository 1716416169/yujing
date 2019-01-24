package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.News.News;
import com.yujing.yujing.dao.admin.News.News_img;
import com.yujing.yujing.dao.admin.News.News_type;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.News_imgPojo;
import com.yujing.yujing.pojo.News_typePojo;
import com.yujing.yujing.pojo.Solution_typePojo;
import com.yujing.yujing.tool.GetDate;
import com.yujing.yujing.tool.Imgdelete;
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
public class NewsController {
    @Autowired
    News news;

    @Autowired
    News_img news_img;

    @Autowired
    News_type news_type;
    @GetMapping(value = "/news")
    public String news(){
        return "admin/news/news";
    }

    @GetMapping(value = "/select_news")
    @ResponseBody
    public Map<Object, Object> select_news(){
        List<NewsPojo> newsPojos = news.select_news();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",newsPojos);
        return objectHashMap;
    }

    @PostMapping(value = "/insert_news")
    @ResponseBody
    //@Transactional
    public void insert_news(NewsPojo newsPojo){
        System.out.println("插入前："+newsPojo);
        if(newsPojo.getAdd_date()==""){
            newsPojo.setAdd_date(new GetDate().Date());
        }
        news.insert_news(newsPojo);
        System.out.println("news:"+newsPojo);
        if(AdminController.pathList!=null){
            for (String st:AdminController.pathList) {
                News_imgPojo news_imgPojo = new News_imgPojo();
                news_imgPojo.setNid(newsPojo.getId());
                news_imgPojo.setPath(st);
                news_img.insert_news_img(news_imgPojo);
            }
        }
        AdminController.pathList=new ArrayList<>();
        System.out.println(newsPojo);
    }

    @PostMapping(value = "/delete_news")
    @ResponseBody
    public void delete_news(NewsPojo newsPojo){
        List<News_imgPojo> news_imgPojos = news_img.select_news_imglist(newsPojo.getId());
        for (News_imgPojo s:news_imgPojos) {
            Imgdelete imgdelete = new Imgdelete();
            imgdelete.deleteImg(s);
        }
        news.delete_news(newsPojo);
        System.out.println(newsPojo);
    }

    @PostMapping(value = "/delete_newss")
    @ResponseBody
    public void delete_newss(@RequestBody List<NewsPojo> newsPojo){
        for (NewsPojo newsPojo1: newsPojo) {
            List<News_imgPojo> news_imgPojos = news_img.select_news_imglist(newsPojo1.getId());
            for (News_imgPojo s:news_imgPojos) {
                Imgdelete imgdelete = new Imgdelete();
                imgdelete.deleteImg(s);
            }
        }
        news.delete_newss(newsPojo);
        System.out.println(newsPojo);
    }


    @GetMapping(value = "/select_newslimit")
    @ResponseBody
    public Map<Object, Object> select_newslimit(Integer in1, Integer in2){
        in1=(in1-1)*in2;
        in2=in1+in2;
        List<NewsPojo> newsPojos = news.select_newslimit(in1, in2);
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
    @GetMapping(value = "/select_count_news")
    public int select_count_news(){
        int i = news.select_count_news();
        System.out.println("新闻总数："+i);
        return i;
    }

    @ResponseBody
    @GetMapping(value = "/select_newstype")
    public Map<Object,Object> select_newstype(){
        List<News_typePojo> news_typePojos = news_type.select_type();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",news_typePojos);
        return objectHashMap;
    }

}
