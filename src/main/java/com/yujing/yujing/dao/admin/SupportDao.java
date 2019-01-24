package com.yujing.yujing.dao.admin;

import com.yujing.yujing.pojo.Support;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupportDao {
    int selectcountsupport();
    List<Support> selectsupportlimit(Integer a, Integer b);
    void deletesupport(Support support);
    void deletesupports(List<Support> supports);
    List<Support> selectsupport();
    void insertsupport(Support support);
}
