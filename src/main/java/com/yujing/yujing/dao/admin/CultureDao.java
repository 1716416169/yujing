package com.yujing.yujing.dao.admin;

import com.yujing.yujing.pojo.Culture;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CultureDao {
    int selectcountculture();
    List<Culture> selectculturelimit(Integer a, Integer b);
    void deleteculture(Culture culture);
    void deletecultures(List<Culture> culture);
    List<Culture> selectculture();
    void insertculture(Culture culture);
}
