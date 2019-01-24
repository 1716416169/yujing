package com.yujing.yujing.service.admin;

import com.yujing.yujing.dao.admin.ProductDao;
import com.yujing.yujing.pojo.*;
import com.yujing.yujing.tool.Imgdelete;
import com.yujing.yujing.tool.Imgupload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    public static List<String> structureimg = new ArrayList<String>();
    public static List<String> productimg = new ArrayList<String>();
    public static List<String> parameterimg = new ArrayList<String>();
    public static List<String> flowimg = new ArrayList<String>();
    public static List<Product_flow> product_flows = new ArrayList<Product_flow>();
    @Autowired
    private ProductDao productDao;

    @Value("${web.Allpath}")
    private String Allpath;

    //上传产品图片
    public Map<Object,Object> uploadproduct(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
       try{
           Imgupload imgupload = new Imgupload();
           Map<Object,Object> map = new HashMap<Object,Object>();
           Map<Object, Object> upload = imgupload.upload(multipartHttpServletRequest.getFile("file"));
           map.put("code",0);
           map.put("msg","666");
           Map<Object,Object> map1 = new HashMap<Object, Object>();
           map1.put("src",Allpath+ File.separator + upload.get("src"));
           map.put("data",map1);
           productimg.add((String) upload.get("src"));
           return map;
       }catch (IOException e){
           return null;
       }
    }
    //上传产品结构图片
    public Map<Object,Object> uploadproductstructure(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        try{
            Imgupload imgupload = new Imgupload();
            Map<Object,Object> map = new HashMap<Object,Object>();
            Map<Object, Object> upload = imgupload.upload(multipartHttpServletRequest.getFile("file"));
            map.put("code",0);
            map.put("msg","666");
            Map<Object,Object> map1 = new HashMap<Object, Object>();
            map1.put("src",Allpath+ File.separator + upload.get("src"));
            map.put("data",map1);
            structureimg.add((String) upload.get("src"));
            return map;
        }catch (IOException e){
            return null;
        }
    }

    public Map<Object,Object> uploadproductparameter(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        try{
            Imgupload imgupload = new Imgupload();
            Map<Object,Object> map = new HashMap<Object,Object>();
            Map<Object, Object> upload = imgupload.upload(multipartHttpServletRequest.getFile("file"));
            map.put("code",0);
            map.put("msg","666");
            Map<Object,Object> map1 = new HashMap<Object, Object>();
            map1.put("src",Allpath+ File.separator + upload.get("src"));
            map.put("data",map1);
            parameterimg.add((String) upload.get("src"));
            return map;
        }catch (IOException e){
            return null;
        }
    }

    public Map<Object,Object> uploadproductflow(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        try{
            Imgupload imgupload = new Imgupload();
            Map<Object,Object> map = new HashMap<Object,Object>();
            Map<Object, Object> upload = imgupload.upload(multipartHttpServletRequest.getFile("file"));
            map.put("code",0);
            map.put("msg","666");
            Map<Object,Object> map1 = new HashMap<Object, Object>();
            map1.put("src",Allpath+ File.separator + upload.get("src"));
            map.put("data",map1);
            flowimg.add((String) upload.get("src"));
            return map;
        }catch (IOException e){
            return null;
        }
    }
    @Transactional
    public void insertproduct(Product product){
        //添加产品图
        List<Product_img> product_imgs = new ArrayList<Product_img>();
        int size = productimg.size();
        for (int i = 0; i < size; i++) {
            System.out.println(productimg.size());
            Product_img product_img= new Product_img();
            product_img.setI_img(productimg.remove(0));
            product_imgs.add( i, product_img);
        }
        product.setProduct_imgs(product_imgs);
        //添加流程
        product.setProduct_flows(product_flows);
        //添加参数图
        product.setParameterimg(parameterimg.remove(parameterimg.size() - 1));
        //添加结构图
        Product_details product_details = product.getProduct_details();
        product_details.setImg(structureimg.remove(structureimg.size()-1));
        //添加基本数据
        productDao.insertproduct(product);
        Integer id = product.getId();
        product.getProduct_details().setPid(id);
        //添加产品详情数据
        productDao.insertproductdetails(product.getProduct_details());
        List<Product_flow> product_flows = product.getProduct_flows();
        for (Product_flow product_flow:product_flows
        ) {
            product_flow.setPid(id);
            //添加流程数据
            productDao.insertproductflow(product_flow);
        }
        List<Product_img> product_imgs1 = product.getProduct_imgs();
        for (Product_img product_img:product_imgs1
        ) {
            product_img.setPid(id);
            //添加流程数据
            productDao.insertproductimg(product_img);
        }
    }
    @Transactional
    public void insertflows(Product_flow product_flow){
        //添加流程图
        product_flow.setImg(flowimg.remove(flowimg.size()-1));
        product_flows.add(product_flow);
    }
    @Transactional
    public void insertproducttype(Product_type product_type){
        System.out.println(product_type.getType_name());
        productDao.insertproducttype(product_type);
    }

    public int selectcountproduct(){
        return productDao.selectcountproduct();
    }

    public Map<Object, Object> selectproducttype(){
        System.out.println("你好！");
        List<Product_type> selectproducttype = productDao.selectproducttype();
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectproducttype);
        return objectHashMap;
    }

    public Map<Object,Object> selectproductlimit(Integer a, Integer b){
        a = (a - 1) * b;
        b = a + b;
        List<Product> selectproductlimit = productDao.selectproductlimit(a, b);
        for (Product product:selectproductlimit
             ) {
            Integer id = product.getId();
            List<Product_flow> selectproductflows = productDao.selectproductflowid(id);
            if(selectproductflows != null){
                product.setProduct_flows(selectproductflows);
            }
            List<Product_img> selectproductimg = productDao.selectproductimgid(id);
            if(selectproductimg != null){
                product.setProduct_imgs(selectproductimg);
            }
            Product_details selectproductdetails = productDao.selectproductdetailsid(id);
            if(selectproductdetails != null){
                product.setProduct_details(selectproductdetails);
            }
        }
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("code",0);
        objectHashMap.put("msg","666");
        objectHashMap.put("count",1000);
        objectHashMap.put("data",selectproductlimit);
        return objectHashMap;
    }
    @Transactional
    public void deleteproduct(Product product){
        Imgdelete imgdelete = new Imgdelete();
        //删除产品图
        List<Product_img> product_imgs = product.getProduct_imgs();
        if (product_imgs != null){
            for (Product_img product_img:product_imgs
            ) {
                imgdelete.deleteImg(product_img.getI_img());
            }
        }
        //删除流程图
        List<Product_flow> product_flows = product.getProduct_flows();
        if (product_flows != null){
            for (Product_flow product_flow:product_flows
            ) {
                imgdelete.deleteImg(product_flow.getImg());
            }
        }
        //删除结构图
        Product_details product_details = product.getProduct_details();
        if (product_details != null){
            imgdelete.deleteImg(product_details.getImg());
        }
        //删除参数图
        String parameterimg = product.getParameterimg();
        if (parameterimg != null){
            imgdelete.deleteImg(parameterimg);
        }
        productDao.deleteproduct(product);
    }
    @Transactional
    public void deleteproducttype(Product_type product_type){
        productDao.deleteproducttype(product_type);
    }
    @Transactional
    public void deleteproducts(List<Product> products){
        Imgdelete imgdelete = new Imgdelete();
        for (Product product:products
             ) {
            //删除产品图
            List<Product_img> product_imgs = product.getProduct_imgs();
            if (product_imgs != null){
                for (Product_img product_img:product_imgs
                ) {
                    imgdelete.deleteImg(product_img.getI_img());
                }
            }
            //删除流程图
            List<Product_flow> product_flows = product.getProduct_flows();
            if (product_flows != null){
                for (Product_flow product_flow:product_flows
                ) {
                    imgdelete.deleteImg(product_flow.getImg());
                }
            }
            //删除结构图
            Product_details product_details = product.getProduct_details();
            if (product_details != null){
                imgdelete.deleteImg(product_details.getImg());
            }
            //删除参数图
            String parameterimg = product.getParameterimg();
            if (parameterimg != null){
                imgdelete.deleteImg(parameterimg);
            }
            productDao.deleteproduct(product);
        }
        productDao.deleteproducts(products);
    }

//    public Map<Object, Object> selectproduct(){
//        List<Product> selectproduct = productDao.selectproduct();
//        HashMap<Object, Object> objectHashMap = new HashMap<>();
//        objectHashMap.put("code",0);
//        objectHashMap.put("msg","666");
//        objectHashMap.put("count",1000);
//        objectHashMap.put("data",selectproduct);
//        return objectHashMap;
//    }

}
