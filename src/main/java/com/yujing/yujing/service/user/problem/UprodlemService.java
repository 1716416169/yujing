package com.yujing.yujing.service.user.problem;

import com.yujing.yujing.dao.user.problem.UproblemDao;
import com.yujing.yujing.pojo.Problem;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UprodlemService {

    @Autowired
    UproblemDao uproblemDao;

    public Pagebean<Problem> uselectproblemlimit(){
        Pagebean<Problem> problemPagebean= new Pagebean<Problem>();
        Integer page = 1;
        Integer number = 12 ;
        Integer total = uproblemDao.uselectcountproblem();
        Integer pagecount = (total / 12) + 1;
        List<Problem> uproblem = uproblemDao.uselectproblemlimit(page, number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(uproblem);
        return problemPagebean;
    }
}
