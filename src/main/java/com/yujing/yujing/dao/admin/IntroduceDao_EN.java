package com.yujing.yujing.dao.admin;

import com.yujing.yujing.pojo.Introduce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IntroduceDao_EN {
    int selectcountintroduce();
    List<Introduce> selectintroducelimit(Integer a, Integer b);
    void deleteintroduce(Introduce introduce);
    void deleteintroduces(List<Introduce> introduces);
    List<Introduce> selectintroduce();
    void insertintroduce(Introduce introduce);
}
