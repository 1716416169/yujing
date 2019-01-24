package com.yujing.yujing.dao.admin;

import com.yujing.yujing.dao.admin.News.News;
import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.Case_imgPojo;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.SolutionPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Search {
    public CasePojo search_case_byname(String name);
    public NewsPojo search_news_byname(String name);
    //public ProductPojo serch_product_byname(String name);
    public SolutionPojo search_solution_byname(String name);


}
