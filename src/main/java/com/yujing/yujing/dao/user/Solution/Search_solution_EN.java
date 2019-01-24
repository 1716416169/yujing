package com.yujing.yujing.dao.user.Solution;

import com.yujing.yujing.pojo.SolutionPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Search_solution_EN {
    @Select("select * from solution_EN where type={param1} limit #{param2},#{param3}")
    @Results({
            @Result(property = "news_solutionPojos_EN",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Solution.Search_solution.search_solution_imgs_imit_EN"))
    })
    public List<SolutionPojo> search_solution_limit_EN(int type, int page, int page1);//根据type查6条

    @Select("select * from solution_EN where id={param1}")
    @Results({
            @Result(property = "news_solutionPojos_EN",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Solution.Search_solution.search_solution_imgs_imit_EN"))
    })
    public SolutionPojo search_solution_limit_ENbyid(int id);//根据type查6条

    @Select("select * from solution_img_EN where nid=#{param1}")
    public List<SolutionPojo> search_solution_imgs_limit_EN(int id);//查全部img

    @Select("select count(*) from solution_EN")
    public Integer search_count_solution_EN();
}

