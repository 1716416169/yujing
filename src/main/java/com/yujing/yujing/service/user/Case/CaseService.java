package com.yujing.yujing.service.user.Case;

import com.yujing.yujing.dao.user.Case.Search_case;
import com.yujing.yujing.dao.user.seniority.Search_seniority;
import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.SeniorityPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

    @Autowired
    Search_case search_case;
    Integer number=6;
    public Pagebean<CasePojo> selectcaselimit(Integer type,Integer page){
        Pagebean<CasePojo> problemPagebean = new Pagebean<>();
        Integer pagecount;
        Integer total = search_case.search_count_case();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<CasePojo> casePojos = search_case.search_case_limit(type, (page - 1) * number, (page - 1) * number + number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(casePojos);
        return problemPagebean;
    }

}
