package com.yujing.yujing.service.admin;

import com.yujing.yujing.dao.admin.EnvironmentalDao;
import com.yujing.yujing.dao.admin.EnvironmentalDao_EN;
import com.yujing.yujing.pojo.Environmental;
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
public class EnvironmentalService_EN {

    public static ArrayList<String> pathList = new ArrayList<>();

    @Autowired
    private EnvironmentalDao_EN environmentalDao;

    @Value("${web.Allpath}")
    private String Allpath;

    public int selectcountenvironmental(){
        return environmentalDao.selectcountenvironmental();
    }

    public Map<Object,Object> uploadenvironmental(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
       try{
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
       }catch (IOException e){
           return null;
       }
    }

    public Map<Object,Object> selectenvironmentallimit(Integer a, Integer b){
        a = (a - 1) * b;
        b = a + b;
        List<Environmental> selectenvironmentallimit = environmentalDao.selectenvironmentallimit(a, b);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectenvironmentallimit);
        return objectHashMap;
    }

    public void deleteenvironmental(Environmental environmental){
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(environmental.getImg());
        environmentalDao.deleteenvironmental(environmental);
    }

    public void deleteenvironmentals(List<Environmental> environmentals){
        Imgdelete imgdelete = new Imgdelete();
        for (Environmental environmental:environmentals
             ) {
            imgdelete.deleteImg(environmental.getImg());
        }
        environmentalDao.deleteenvironmentals(environmentals);
    }

    public Map<Object, Object> selectenvironmental(){
        List<Environmental> selectenvironmental = environmentalDao.selectenvironmental();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectenvironmental);
        return objectHashMap;
    }

    public void insertenvironmental(Environmental environmental){
        environmental.setImg(pathList.remove(pathList.size()-1));
        environmentalDao.insertenvironmental(environmental);
    }

}
