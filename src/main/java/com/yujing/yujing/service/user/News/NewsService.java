package com.yujing.yujing.service.user.News;

import com.yujing.yujing.dao.user.Case.Search_case;
import com.yujing.yujing.dao.user.News.Search_news;
import com.yujing.yujing.pojo.CasePojo;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.pojo.SolutionPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    Search_news search_news;
    Integer number=3;
    public Pagebean<NewsPojo> selectnewslimit(Integer page, Integer type){
        System.out.println("page:"+page);
        Pagebean<NewsPojo> problemPagebean = new Pagebean<>();
        Integer pagecount;
        Integer total = search_news.search_count_news();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<NewsPojo> newsPojos = search_news.search_news_limit(type, (page - 1) * number, (page - 1) * number + number);
        System.out.println("old:"+newsPojos);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(newsPojos);
        return problemPagebean;
    }


}
