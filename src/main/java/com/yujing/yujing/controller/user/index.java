package com.yujing.yujing.controller.user;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yujing.yujing.dao.user.Case.Search_case;
import com.yujing.yujing.dao.user.News.Search_news;
import com.yujing.yujing.dao.user.Solution.Search_solution;
import com.yujing.yujing.pojo.*;
import com.yujing.yujing.service.user.Case.CaseService;
import com.yujing.yujing.service.user.News.NewsService;
import com.yujing.yujing.service.user.Solution.SolutionService;
import com.yujing.yujing.service.user.Video.VideoService;
import com.yujing.yujing.service.user.seniority.SeniorityService;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sun.awt.SunHints;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Controller
public class index {
    @Autowired
    SeniorityService seniorityService;
    @Autowired
    CaseService caseService;
    @Autowired
    NewsService newsService;
    @Autowired
    SolutionService solutionService;
    @Autowired
    Search_news search_news;
    @Autowired
    Search_case search_case;

    @Autowired
    Search_solution search_solution;
    @Value("${web.Allpath}")
    private String Allpath;

    @Autowired
    VideoService videoService;
    @GetMapping(value = "/")
    public String index(){
        return "user/index";
    }

    @GetMapping(value = "soltion/index")
    public String soltion_user(Model model,Integer page,Integer type){
        if (page == null) {
            page = 1;
        }
        if(type==null){
            type=1;
        }
        System.out.println("page:"+page);
        Pagebean<SolutionPojo> selectsolutionlimit = solutionService.selectsolutionlimit(page, type);
        model.addAttribute("sol", selectsolutionlimit);
        model.addAttribute("all", Allpath);
        List<Integer> list = new ArrayList<>();
        int i = 1;
        Integer pagecount = selectsolutionlimit.getPagecount();
        for (; pagecount > 0; pagecount--) {
            list.add(i++);
        }
        model.addAttribute("pages", list);
        model.addAttribute("index", 1);
        System.out.println("查询的解决：" + selectsolutionlimit);
        return "user/soltion/index";
    }
    @GetMapping(value = "soltion/detail/{id}")
    public String soltion_detaile_user(@PathVariable Integer id,Model model){
        System.out.println(id);
        SolutionPojo solutionPojo = search_solution.search_solution_limitbyid(id);
        System.out.println(solutionPojo);
        model.addAttribute("soltion",solutionPojo);
        model.addAttribute("all", Allpath);
        return "user/soltion/detail";
    }

    @GetMapping(value = "physical/detail/{id}")
    public String physical_detaile_user(@PathVariable Integer id,Model model){
        System.out.println(id);
        CasePojo casePojo = search_case.search_case_limitbyid(id);
        System.out.println(casePojo);
        model.addAttribute("physical",casePojo);
        model.addAttribute("all", Allpath);
        return "user/physical/detail";
    }



    @GetMapping(value = "physical/index")
    public String physical_user(Model model,Integer page,Integer type){
        if (page == null) {
            List<Integer> list = search_case.search_type_case();
            page = list.get(0);
        }
        if(type==null){

            type=1;
        }
        System.out.println("page:"+page);
        Pagebean<CasePojo> selectcaselimit = caseService.selectcaselimit(page, type);
        model.addAttribute("ca", selectcaselimit);
        model.addAttribute("all", Allpath);
        List<Integer> list = new ArrayList<>();
        int i = 1;
        Integer pagecount = selectcaselimit.getPagecount();
        for (; pagecount > 0; pagecount--) {
            list.add(i++);
        }
        model.addAttribute("pages", list);
        model.addAttribute("index", 1);
        model.addAttribute("caseone",Allpath+ File.separator+selectcaselimit.getList().get(0).getCase_imgPojos().get(0).getPath());
        System.out.println("链表："+selectcaselimit.getList().get(0).getCase_imgPojos().get(0).getPath());
        System.out.println("查询的案例：" + selectcaselimit);
        return "user/physical/index";
    }

    @GetMapping(value = "physical/detail")
    public String physical_detaile_user(){
        return "user/physical/detail";
    }

    @GetMapping(value = "services/index")
    public String services_user(){
        return "user/services/index";
    }

    @GetMapping(value = "services/detail")
    public String services_detaile_user(){
        return "user/services/detail";
    }


    @GetMapping(value = "profile/index")
    public String profile_user(){
        return "user/profile/index";
    }

    @GetMapping(value = "profile/detail/{id}")
    public String profile_detaile_user(@PathVariable Integer id){
        System.out.println(id);
        return "user/services/detail";
    }

    @GetMapping(value = "news/index")
    public String news_user(Model model,Integer page,Integer type){
        if (page == null) {
            page = 1;
        }
        if(type==null){
            type=1;
        }
        System.out.println("page:"+page);
        Pagebean<NewsPojo> selectnewslimit = newsService.selectnewslimit(page, type);
        Model sol = model.addAttribute("news",selectnewslimit);
        model.addAttribute("all", Allpath);
        List<Integer> list = new ArrayList<>();
        int i = 1;
        Integer pagecount = selectnewslimit.getPagecount();
        for (; pagecount > 0; pagecount--) {
            list.add(i++);
        }
        model.addAttribute("pages", list);
        model.addAttribute("index", 1);
        System.out.println("查询的新闻：" + selectnewslimit);
        model.addAttribute("newsone",Allpath+ File.separator+selectnewslimit.getList().get(0).getNews_imgPojos().get(0).getPath());
        System.out.println("链表："+selectnewslimit.getList().get(0).getNews_imgPojos().get(0).getPath());
        return "user/news/index";
    }

    @GetMapping(value = "contact/index")
    public String contact_user(){
        return "user/contact/index";
    }


    @GetMapping(value = "news/detail/{id}")
    public String news_detaile_user(@PathVariable Integer id,Model model){
        System.out.println(id);
        NewsPojo newsPojo = search_news.search_news_limitById(id);
        System.out.println(newsPojo);
        model.addAttribute("news",newsPojo);
        return "user/news/detail";
    }

    @GetMapping(value = "news/detailhou/{id}")
    public String news_detaile_userhou(@PathVariable Integer id,Model model){
        System.out.println(id);
        Integer integer = search_news.search_count_news();
        NewsPojo newsPojo = search_news.search_news_limitById(++id);
        if(newsPojo==null){
            while(integer--!=0){
                newsPojo = search_news.search_news_limitById(++id);
                if(newsPojo!=null){
                    break;
                }
            }
        }
        System.out.println(newsPojo);
        model.addAttribute("news",newsPojo);
        return "user/news/detail";
    }
    @GetMapping(value = "soltion/detailhou/{id}")
    public String soltion_detaile_userhou(@PathVariable Integer id,Model model){
        System.out.println(id);
        Integer integer = search_solution.search_count_solution();
        SolutionPojo solutionPojo = search_solution.search_solution_limitbyid(++id);
        if(solutionPojo==null){
            while(integer--!=0){
                solutionPojo = search_solution.search_solution_limitbyid(++id);
                if(solutionPojo!=null){
                    break;
                }
            }
        }
        System.out.println(solutionPojo);
        model.addAttribute("soltion",solutionPojo);
        return "user/soltion/detail";
    }

    @GetMapping(value = "soltion/detailqian/{id}")
    public String soltion_detaile_useqian(@PathVariable Integer id,Model model){
        System.out.println(id);
        Integer integer = search_solution.search_count_solution();
        SolutionPojo solutionPojo = search_solution.search_solution_limitbyid(--id);
        if(solutionPojo==null){
            while(integer--!=0){
                solutionPojo = search_solution.search_solution_limitbyid(++id);
                if(solutionPojo!=null){
                    break;
                }
            }
        }
        System.out.println(solutionPojo);
        model.addAttribute("soltion",solutionPojo);
        return "user/soltion/detail";
    }


    @GetMapping(value = "news/detailqian/{id}")
    public String news_detaile_userqian(@PathVariable Integer id,Model model){
        System.out.println(id);
        Integer integer = search_news.search_count_news();
        NewsPojo newsPojo = search_news.search_news_limitById(--id);
        if(newsPojo==null){
            while(integer--!=0){
                newsPojo = search_news.search_news_limitById(--id);
                if(newsPojo!=null){
                    break;
                }
            }
        }
        System.out.println(newsPojo);
        model.addAttribute("news",newsPojo);
        return "user/news/detail";
    }


    @GetMapping(value = "profile/qualification")
    public String qualification_user(Integer page,Model model){
        if (page == null) {
            page = 1;
        }
        Pagebean<SeniorityPojo> selectsenioritylimit = seniorityService.selectsenioritylimit(page);
        model.addAttribute("img", selectsenioritylimit);
        model.addAttribute("all", Allpath);
        List<Integer> list = new ArrayList<>();
        int i = 1;
        Integer pagecount = selectsenioritylimit.getPagecount();
        for (; pagecount > 0; pagecount--) {
            list.add(i++);
        }
        model.addAttribute("pages", list);
        model.addAttribute("index", 1);
        System.out.println("查询的公司资质图片：" + selectsenioritylimit);
        return "user/profile/qualification";
    }

    @GetMapping(value = "profile/video")
    public String video_user(Integer page, Model model){
        if (page == null) {
            page = 1;
        }
        Pagebean<VideoPojo> selectvideolimit = videoService.selectvideolimit(page);
        model.addAttribute("video", selectvideolimit);
        model.addAttribute("all", Allpath);
        List<Integer> list = new ArrayList<>();
        int i = 1;
        Integer pagecount = selectvideolimit.getPagecount();
        for (; pagecount > 0; pagecount--) {
            list.add(i++);
        }
        model.addAttribute("pages", list);
        model.addAttribute("index", 1);
        System.out.println("查询的视频：" + selectvideolimit);
        return "user/profile/video";
    }

    @GetMapping(value = "soltion/type/{type}")
    public String soltion_type(@PathVariable Integer type,Model model){
        Pagebean<SolutionPojo> selectsolutionlimit = solutionService.selectsolutionlimit(1, type);
        model.addAttribute("sol", selectsolutionlimit);
        model.addAttribute("all", Allpath);
        List<Integer> list = new ArrayList<>();
        int i = 1;
        Integer pagecount = selectsolutionlimit.getPagecount();
        for (; pagecount > 0; pagecount--) {
            list.add(i++);
        }
        System.out.println("222222222222222222"+selectsolutionlimit);
        model.addAttribute("pages", list);
        model.addAttribute("index", 1);
        model.addAttribute("soltionone",Allpath+ File.separator+selectsolutionlimit.getList().get(0).getNews_solutionPojos().get(0).getPath());
        System.out.println("查询的新闻：" + selectsolutionlimit);
        return "user/soltion/index";
    }

    @GetMapping(value = "news/type/{type}")
    public String news_type(@PathVariable Integer type,Model model){
        Pagebean<NewsPojo> selectnewslimit = newsService.selectnewslimit(1, type);
        model.addAttribute("news", selectnewslimit);
        model.addAttribute("all", Allpath);
        List<Integer> list = new ArrayList<>();
        int i = 1;
        Integer pagecount = selectnewslimit.getPagecount();
        for (; pagecount > 0; pagecount--) {
            list.add(i++);
        }
        System.out.println("222222222222222222"+selectnewslimit);
        model.addAttribute("pages", list);
        model.addAttribute("index", 1);
        model.addAttribute("newsone",Allpath+ File.separator+selectnewslimit.getList().get(0).getNews_imgPojos().get(0).getPath());
        System.out.println("查询的新闻：" + selectnewslimit);
        return "user/news/index";
    }

}

