package com.yujing.yujing.dao.user.Case;

import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.Case_imgPojo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface Search_case {
    @Select("select *,id idd from ca where type=#{p1} limit #{p2},#{p3}")
    @Results({
            @Result(property = "id",column = "idd"),
            @Result(property = "case_imgPojos",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Case.Search_case.search_case_imgs_limit"))
    })
    public List<CasePojo> search_case_limit(@Param("p1") Integer type, @Param("p2")Integer page, @Param("p3")Integer page1);//根据type查6条

    @Select("select *,id idd from ca where id=#{p1}")
    @Results({
            @Result(property = "id",column = "idd"),
            @Result(property = "case_imgPojos",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Case.Search_case.search_case_imgs_limit"))
    })
    public CasePojo search_case_limitbyid(@Param("p1")int id);//根据type查6条

    @Select("select * from case_img where cid=#{p1}")
    public List<Case_imgPojo> search_case_imgs_limit(@Param("p1")int id);//查全部img

    @Select("select count(*) from ca")
    public Integer search_count_case();

    @Select("select id from case_type")
    public List<Integer> search_type_case();
}
