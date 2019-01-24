package com.yujing.yujing.service.user.Case;

import com.yujing.yujing.dao.user.Case.Search_case;
import com.yujing.yujing.dao.user.Case.Search_case_EN;
import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService_EN {

    @Autowired
    Search_case_EN search_case_EN;
    public Pagebean<CasePojo> selectcaselimit_EN(Integer type,Integer page,Integer number){
        Pagebean<CasePojo> problemPagebean = new Pagebean<>();
        Integer pagecount;
        Integer total = search_case_EN.search_count_case_EN();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<CasePojo> casePojos = search_case_EN.search_case_limit_EN(type, (pagecount - 1) * number, (pagecount - 1) * number + number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(casePojos);
        return problemPagebean;
    }

}
