package com.yujing.yujing.service.admin;

import com.yujing.yujing.dao.admin.CultureDao_EN;
import com.yujing.yujing.pojo.Culture;
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
public class CultureService_EN {

    public static ArrayList<String> pathList = new ArrayList<>();

    @Autowired
    private CultureDao_EN cultureDao;

    @Value("${web.Allpath}")
    private String Allpath;

    public int selectcountculture(){
        return cultureDao.selectcountculture();
    }

    public Map<Object,Object> uploadculture(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
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

    public Map<Object,Object> selectculturelimit(Integer a, Integer b){
        a = (a - 1) * b;
        b = a + b;
        List<Culture> selectculturelimit = cultureDao.selectculturelimit(a, b);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectculturelimit);
        return objectHashMap;
    }

    public void deleteculture(Culture culture){
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(culture.getImg());
        cultureDao.deleteculture(culture);
    }

    public void deletecultures(List<Culture> cultures){
        Imgdelete imgdelete = new Imgdelete();
        for (Culture culture:cultures
             ) {
            imgdelete.deleteImg(culture.getImg());
        }
        cultureDao.deletecultures(cultures);
    }

    public Map<Object, Object> selectculture(){
        List<Culture> selectculture = cultureDao.selectculture();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectculture);
        return objectHashMap;
    }

    public void insertculture(Culture culture){
        culture.setImg(pathList.remove(pathList.size()-1));
        System.out.println(culture.getName());
        System.out.println(culture.getImg());
        System.out.println(culture.getText());
        cultureDao.insertculture(culture);
    }

}
