package com.yujing.yujing.service.admin;

import com.yujing.yujing.dao.admin.IntroduceDao;
import com.yujing.yujing.dao.admin.IntroduceDao_EN;
import com.yujing.yujing.pojo.Introduce;
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
public class IntroduceService_EN {

    public static ArrayList<String> pathList = new ArrayList<>();

    @Autowired
    private IntroduceDao_EN introduceDao;

    @Value("${web.Allpath}")
    private String Allpath;

    public int selectcountintroduce(){
        return introduceDao.selectcountintroduce();
    }

    public Map<Object,Object> uploadintroduce(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
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

    public Map<Object,Object> selectintroducelimit(Integer a, Integer b){
        a = (a - 1) * b;
        b = a + b;
        List<Introduce> selectintroducelimit = introduceDao.selectintroducelimit(a, b);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectintroducelimit);
        return objectHashMap;
    }

    public void deleteintroduce(Introduce introduce){
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(introduce.getImg());
        introduceDao.deleteintroduce(introduce);
    }

    public void deleteintroduces(List<Introduce> introduces){
        Imgdelete imgdelete = new Imgdelete();
        for (Introduce introduce:introduces
             ) {
            imgdelete.deleteImg(introduce.getImg());
        }
        introduceDao.deleteintroduces(introduces);
    }

    public Map<Object, Object> selectintroduce(){
        List<Introduce> selectintroduce = introduceDao.selectintroduce();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectintroduce);
        return objectHashMap;
    }

    public void insertintroduce(Introduce introduce){
        introduce.setImg(pathList.remove(pathList.size()-1));
        System.out.println(introduce.getName());
        System.out.println(introduce.getImg());
        System.out.println(introduce.getText());
        introduceDao.insertintroduce(introduce);
    }

}
