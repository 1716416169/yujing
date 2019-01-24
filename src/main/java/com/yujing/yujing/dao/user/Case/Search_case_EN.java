package com.yujing.yujing.dao.user.Case;

import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.Case_imgPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Search_case_EN {
    @Select("select * from ca_EN where type={param1} limit #{param2},#{param3}")
    @Results({
            @Result(property = "case_imgPojos_EN",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Case.Search_case.search_case_imgs_imit_EN"))
    })
    public List<CasePojo> search_case_limit_EN(int type, int page, int page1);//根据type查6条


    @Select("select * from ca_EN where id={param1}")
    @Results({
            @Result(property = "case_imgPojos_EN",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Case.Search_case.search_case_imgs_imit_EN"))
    })
    public CasePojo search_case_limit_ENbyid(int id);//根据type查6条

    @Select("select * from case_img_EN where cid=#{param1}")
    public List<Case_imgPojo> search_case_imgs_limit_EN(int id);//查全部img

    @Select("select count(*) from case_EN")
    public Integer search_count_case_EN();
}
