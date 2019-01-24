package com.yujing.yujing.service.user.Solution;

import com.yujing.yujing.dao.user.News.Search_news;
import com.yujing.yujing.dao.user.Solution.Search_solution;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.SolutionPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolutionService {
    @Autowired
    Search_solution search_solution;
    Integer number=3;
    public Pagebean<SolutionPojo> selectsolutionlimit(Integer page,Integer type){
        System.out.println("page:"+page);
        Pagebean<SolutionPojo> problemPagebean = new Pagebean<>();
        Integer pagecount;
        Integer total = search_solution.search_count_solution();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<SolutionPojo> solutionPojos = search_solution.search_solution_limit(type, (page - 1) * number, (page - 1) * number + number);
        System.out.println("old:"+solutionPojos);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(solutionPojos);
        return problemPagebean;
    }
}
