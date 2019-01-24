package com.yujing.yujing.service.admin;

import com.yujing.yujing.dao.admin.FlowDao;
import com.yujing.yujing.dao.admin.FlowDao_EN;
import com.yujing.yujing.pojo.Flow;
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
public class FlowService_EN {

    public static ArrayList<String> pathList = new ArrayList<>();

    @Autowired
    private FlowDao_EN flowDao;

    @Value("${web.Allpath}")
    private String Allpath;

    public int selectcountflow(){
        return flowDao.selectcountflow();
    }

    public Map<Object,Object> uploadflow(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
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

    public Map<Object,Object> selectflowlimit(Integer a, Integer b){
        a = (a - 1) * b;
        b = a + b;
        List<Flow> selectflowlimit = flowDao.selectflowlimit(a, b);
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectflowlimit);
        return objectHashMap;
    }

    public void deleteflow(Flow flow){
        Imgdelete imgdelete = new Imgdelete();
        imgdelete.deleteImg(flow.getImg());
        flowDao.deleteflow(flow);
    }

    public void deleteflows(List<Flow> flows){
        Imgdelete imgdelete = new Imgdelete();
        for (Flow flow:flows
             ) {
            imgdelete.deleteImg(flow.getImg());
        }
        flowDao.deleteflows(flows);
    }

    public Map<Object, Object> selectflow(){
        List<Flow> selectflow = flowDao.selectflow();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectflow);
        return objectHashMap;
    }

    public void insertflow(Flow flow){
        flow.setImg(pathList.remove(pathList.size()-1));
        flowDao.insertflow(flow);
    }

}
