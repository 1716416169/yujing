package com.yujing.yujing.service.admin;

import com.yujing.yujing.dao.admin.ProblemDao;
import com.yujing.yujing.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProblemService {
    @Autowired
    private ProblemDao problemDao;

    public void insertproblem(Problem problem) {
        problemDao.insertproblem(problem);
    }

    public void deleteproblem(Problem problem) {
        problemDao.deleteproblem(problem);
    }

    public Integer selectcountproblem() {
        return problemDao.selectcountproblem();
    }

    public List<Problem> selectproblemlimit(int in1, int in2) {
        return problemDao.selectproblemlimit(in1, in2);
    }

    public List<Problem> selectproblem() {
        return problemDao.selectproblem();
    }

    public void deleteproblems(List<Problem> problems) {
        problemDao.deleteproblems(problems);
    }

}