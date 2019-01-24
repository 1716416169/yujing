package com.yujing.yujing.dao.admin;

import com.yujing.yujing.pojo.Environmental;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnvironmentalDao_EN {
    int selectcountenvironmental();
    List<Environmental> selectenvironmentallimit(Integer a, Integer b);
    void deleteenvironmental(Environmental environmental);
    void deleteenvironmentals(List<Environmental> environmental);
    List<Environmental> selectenvironmental();
    void insertenvironmental(Environmental environmental);
}
