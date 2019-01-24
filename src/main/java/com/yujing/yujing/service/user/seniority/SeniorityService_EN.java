package com.yujing.yujing.service.user.seniority;

import com.yujing.yujing.dao.user.seniority.Search_seniority;
import com.yujing.yujing.dao.user.seniority.Search_seniority_EN;
import com.yujing.yujing.pojo.SeniorityPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeniorityService_EN {
    @Autowired
    Search_seniority_EN search_seniority_EN;
    public Pagebean<SeniorityPojo> selectsenioritylimit_EN(Integer page, Integer number){
        Pagebean<SeniorityPojo> problemPagebean= new Pagebean<SeniorityPojo>();
        Integer pagecount;
        Integer total = search_seniority_EN.search_count_seniority_EN();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<SeniorityPojo> seniorityPojos = search_seniority_EN.search_seniority_limit_EN((pagecount - 1) * number, (pagecount - 1) * number + number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(seniorityPojos);
        return problemPagebean;
    }
}
