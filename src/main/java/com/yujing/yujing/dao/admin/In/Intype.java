package com.yujing.yujing.dao.admin.In;

import com.yujing.yujing.pojo.InPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Intype {
    @Update("update intype set type = #{type},type2=#{type2},type3=#{type3},type4=#{type4} where id=1")
    public void updataIn(InPojo inPojo);
}
