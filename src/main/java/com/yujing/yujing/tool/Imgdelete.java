package com.yujing.yujing.tool;

import com.yujing.yujing.pojo.News_imgPojo;
import com.yujing.yujing.pojo.Solution_imgPojo;

import java.io.File;

public class Imgdelete {
    public void deleteImg(Solution_imgPojo solution_imgPojo){
        File file = new File(solution_imgPojo.getPath());
        file.delete();
        System.out.println("删除的文件："+file);
    }

    public void deleteImg(String st){
        File file = new File(st);
        file.delete();
        System.out.println("删除的文件："+file);
    }

    public void deleteImg(News_imgPojo news_imgPojo){
        File file = new File(news_imgPojo.getPath());
        file.delete();
        System.out.println("删除的文件："+file);
    }
}
