package com.yujing.yujing.service.user.News;

import com.yujing.yujing.dao.user.News.Search_news;
import com.yujing.yujing.dao.user.News.Search_news_EN;
import com.yujing.yujing.pojo.NewsPojo;
import com.yujing.yujing.tool.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService_EN {
    @Autowired
    Search_news_EN search_news_EN;
    public Pagebean<NewsPojo> selectcaselimit_EN(Integer type, Integer page, Integer number){
        Pagebean<NewsPojo> problemPagebean = new Pagebean<>();
        Integer pagecount;
        Integer total = search_news_EN.search_count_news_EN();
        if((total % number)!=0){
            pagecount = (total / number) + 1;
        }else{
            pagecount = (total / number);
        }
        List<NewsPojo> newsPojos = search_news_EN.search_news_limit_EN(type, (pagecount - 1) * number, (pagecount - 1) * number + number);
        problemPagebean.setTotal(total);
        problemPagebean.setNumber(number);
        problemPagebean.setPagecount(pagecount);
        problemPagebean.setPage(page);
        problemPagebean.setList(newsPojos);
        return problemPagebean;
    }
}
