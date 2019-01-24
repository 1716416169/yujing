package com.yujing.yujing.dao.admin;

import com.yujing.yujing.pojo.Flow;
import com.yujing.yujing.pojo.Introduce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FlowDao {
    int selectcountflow();
    List<Flow> selectflowlimit(Integer a, Integer b);
    void deleteflow(Flow flow);
    void deleteflows(List<Flow> flow);
    List<Flow> selectflow();
    void insertflow(Flow flow);
}
