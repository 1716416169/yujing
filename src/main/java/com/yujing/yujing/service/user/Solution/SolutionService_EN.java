package com.yujing.yujing.service.user.Solution;

import com.yujing.yujing.dao.user.Solution.Search_solution;
import com.yujing.yujing.dao.user.Solution.Search_solution_EN;
import com.yujing.yujing.pojo.SolutionPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SolutionService_EN {
    @Autowired
    Search_solution_EN search_solution_EN;
    public Pagebean<SolutionPojo> selectsolutionlimit_EN(Integer type, Integer page, Integer number){
        Pagebean<SolutionPojo> problemPagebean = new Pagebean<>();
        Integer pagecount;
        Integer total = search_solution_EN.search_count_solution_EN();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<SolutionPojo> solutionPojos = search_solution_EN.search_solution_limit_EN(type, (pagecount - 1) * number, (pagecount - 1) * number + number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(solutionPojos);
        return problemPagebean;
    }
}
