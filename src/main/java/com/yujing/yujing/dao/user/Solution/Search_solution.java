package com.yujing.yujing.dao.user.Solution;

import com.yujing.yujing.dao.admin.Solution.Solution;
import com.yujing.yujing.dao.admin.Solution.Solution_img;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.News_imgPojo;
import com.yujing.yujing.pojo.SolutionPojo;
import com.yujing.yujing.pojo.Solution_imgPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Search_solution {
    @Select("select *,id idd from solution where type=#{p1} limit #{p2},#{p3}")
    @Results({
            @Result(property = "id",column = "idd"),
            @Result(property = "news_solutionPojos",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Solution.Search_solution.search_solution_imgs_limit"))
    })
    public List<SolutionPojo> search_solution_limit(@Param("p1") Integer type, @Param("p2")Integer page, @Param("p3")Integer page1);//根据type查6条

    @Select("select * from solution_img where sid=#{param1}")
    public List<Solution_imgPojo> search_solution_imgs_limit(int id);//查全部img

    @Select("select count(*) from solution")
    public Integer search_count_solution();

    @Select("select * from solution where id=#{p1}")
    @Results({
            @Result(property = "news_solutionPojos",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Solution.Search_solution.search_solution_imgs_limit"))
    })
    public SolutionPojo search_solution_limit2(@Param("p1") Integer type);

    @Select("select * from solution where type =#{p1} limit #{p2},#{p3}")
    public List<Integer> search_solutions(@Param("p1") Integer type, @Param("p2")Integer page, @Param("p3")Integer page1);

    @Select("select *,id idd from solution where id=#{p1}")
    @Results({
            @Result(property = "id",column = "idd"),
            @Result(property = "news_solutionPojos",column = "id",many = @Many(select = "com.yujing.yujing.dao.user.Solution.Search_solution.search_solution_imgs_limit"))
    })
    public SolutionPojo search_solution_limitbyid(@Param("p1")int id);//根据type查6条
}

