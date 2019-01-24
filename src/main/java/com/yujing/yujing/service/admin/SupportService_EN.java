package com.yujing.yujing.service.admin;

import com.yujing.yujing.dao.admin.SupportDao_EN;
import com.yujing.yujing.pojo.Support;
import com.yujing.yujing.tool.Imgdelete;
import com.yujing.yujing.tool.Imgupload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupportService_EN {

    public static ArrayList<String> pathList = new ArrayList<>();

    @Autowired
    private SupportDao_EN supportDao;

    @Value("${web.Allpath}")
    private String Allpath;

    public int selectcountsupport(){
        return supportDao.selectcountsupport();
    }

    public Map<Object,Object> uploadsupport(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
        Imgupload imgupload = new Imgupload();
        Map<Object,Object> map = new HashMap<Object,Object>();
        Map<Object, Object> upload = imgupload.upload(multipartHttpServletRequest.getFile("file"));
        map.put("code",0);
        map.put("msg","666");
        Map<Object,Object> map1 = new HashMap<Object, Object>();
        map1.put("src",Allpath+ File.separator + upload.get("src"));
        map.put("data",map1);
        System.out.println(upload.get("src"));
        pathList.add((String) upload.get("src"));
        System.out.println("上传的文件集合是："+ pathList);
        return map;
    }

    public Map<Object,Object> selectsupportlimit(Integer a, Integer b){
        a = (a - 1) * b;
        b = a + b;
        List<Support> selectsupportlimit = supportDao.selectsupportlimit(a, b);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectsupportlimit);
        return objectHashMap;
    }

    public void deletesupport(Support support){
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(support.getImg());
        supportDao.deletesupport(support);
    }

    public void deletesupports(List<Support> supports){
        System.out.println(2);
        Imgdelete imgdelete = new Imgdelete();
        for (Support support:supports
             ) {
            imgdelete.deleteImg(support.getImg());
        }
        supportDao.deletesupports(supports);
    }

    public Map<Object, Object> selectsupport(){
        List<Support> selectsupport = supportDao.selectsupport();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectsupport);
        return objectHashMap;
    }

    public  void insertsupport(Support support){
        support.setImg(pathList.remove(pathList.size()-1));
        System.out.println(support.getName());
        System.out.println(support.getImg());
        System.out.println(support.getText());
        supportDao.insertsupport(support);
    }

}
