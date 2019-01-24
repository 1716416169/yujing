package com.yujing.yujing.dao.admin.Solution;

import com.yujing.yujing.pojo.SolutionPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Solution_EN {

    public void insert_solution(SolutionPojo solutionPojo);

    public List<SolutionPojo> select_solution();

    public void delete_solution(SolutionPojo solutionPojo);

    public void delete_solutions(List<SolutionPojo> solutionPojos);

    public List<SolutionPojo> select_solutionlimit(Integer in1, Integer in2);

    public int select_count_solution();
}
