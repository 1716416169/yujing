package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.Case.Case;
import com.yujing.yujing.dao.admin.Search;
import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.SolutionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.management.MalformedObjectNameException;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    Search search;
    @Autowired
    Case ca;
    @GetMapping(value = "/search/{key}")
    public String search(@PathVariable String key,Model model){
        System.out.println(key);
        CasePojo casePojos = search.search_case_byname(key);
        if(casePojos!=null){

            return "";
        }
        NewsPojo newsPojo = search.search_news_byname(key);
        if(newsPojo!=null){
            return "";
        }
        SolutionPojo solutionPojo = search.search_solution_byname(key);
        if(solutionPojo!=null){
            return "";
        }
        return null;
    }
}
