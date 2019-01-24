package com.yujing.yujing.service.user.seniority;

import com.yujing.yujing.dao.user.Case.Search_case;
import com.yujing.yujing.dao.user.seniority.Search_seniority;
import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.SeniorityPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeniorityService {
    @Value("${web.Allpath}")
    private String Allpath;
    Integer number=9;
    @Autowired
    Search_seniority search_seniority;
    public Pagebean<SeniorityPojo> selectsenioritylimit(Integer page){
        Pagebean<SeniorityPojo> problemPagebean= new Pagebean<SeniorityPojo>();
        Integer pagecount;
        Integer total = search_seniority.search_count_seniority();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<SeniorityPojo> seniorityPojos = search_seniority.search_seniority_limit((page - 1) * number, (page - 1) * number + number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(seniorityPojos);
        return problemPagebean;
    }
}
