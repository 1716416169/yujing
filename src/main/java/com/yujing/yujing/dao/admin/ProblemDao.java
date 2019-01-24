package com.yujing.yujing.dao.admin;

import com.yujing.yujing.pojo.Problem;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProblemDao {
    void insertproblem(Problem problem);
    void deleteproblem(Problem problem);
    Integer selectcountproblem();
    List<Problem> selectproblemlimit(int in1, int in2);
    List<Problem> selectproblem();
    void deleteproblems(List<Problem> problems);
}
