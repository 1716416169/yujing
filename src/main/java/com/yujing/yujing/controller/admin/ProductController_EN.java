package com.yujing.yujing.controller.admin;

import com.yujing.yujing.pojo.Product;
import com.yujing.yujing.pojo.Product_flow;
import com.yujing.yujing.pojo.Product_type;
import com.yujing.yujing.service.admin.ProductService;
import com.yujing.yujing.service.admin.ProductService_EN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController_EN {

    @Autowired
    private ProductService_EN productService;

    @GetMapping(value = "/product_EN")
    public String product(){
        return "admin/product/product_EN";
    }

    @PostMapping(value = "/uploadproductstructure_EN")//上传产品结构图片
    @ResponseBody
    public Map<Object,Object> uploadproductstructure(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        Map<Object, Object> map = productService.uploadproductstructure(file, multipartHttpServletRequest);
        return map;
    }

    @PostMapping(value = "/uploadproduct_EN")//上传产品图片
    @ResponseBody
    public Map<Object,Object> uploadproduct(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        Map<Object, Object> map = productService.uploadproduct(file, multipartHttpServletRequest);
        return map;
    }

    @PostMapping(value = "/uploadproductparameter_EN")//上传产品参数图片
    @ResponseBody
    public Map<Object,Object> uploadproductparameter(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        Map<Object, Object> map = productService.uploadproductparameter(file, multipartHttpServletRequest);
        return map;
    }

    @PostMapping(value = "/uploadproductflow_EN")//上传流程参数图片
    @ResponseBody
    public Map<Object,Object> uploadproductflow(MultipartFile file, MultipartHttpServletRequest multipartHttpServletRequest){
        Map<Object, Object> map = productService.uploadproductflow(file, multipartHttpServletRequest);
        return map;
    }

    @PostMapping(value = "/insertproduct_EN")
    @ResponseBody
    public void insertproduct(@RequestBody Product product){
        productService.insertproduct(product);
    }

    @PostMapping(value = "/insertflows_EN")
    @ResponseBody
    public void insertflows(Product_flow product_flow){
        System.out.println(product_flow.getText());
        productService.insertflows(product_flow);
    }

    @PostMapping(value = "/insertproducttype_EN")
    @ResponseBody
    public void insertproducttype(Product_type product_type){
        System.out.println(product_type.getType_name());
        productService.insertproducttype(product_type);
    }

    @GetMapping(value = "/selectcountproduct_EN")
    @ResponseBody
    public int selectcountproduct(){
        return productService.selectcountproduct();
    }

    @GetMapping(value = "/selectproducttype_EN")
    @ResponseBody
    public Map<Object, Object> selectproducttype(){
        return productService.selectproducttype();
    }

    @GetMapping(value = "/selectproductlimit_EN")
    @ResponseBody
    public Map<Object,Object> selectproductlimit(Integer a, Integer b){
        return productService.selectproductlimit(a , b);
    }

//    @GetMapping(value = "/selectproduct")
//    @ResponseBody
//    public Map<Object, Object> selectproduct(){
//        return productService.selectproduct();
//    }

    @PostMapping(value = "/deleteproduct_EN",consumes = "application/json")
    @ResponseBody
    public void deleteproduct(@RequestBody Product product){
        System.out.println(444);
        productService.deleteproduct(product);
    }

    @PostMapping(value = "/deleteproducttype_EN")
    @ResponseBody
    public void deleteproducttype(Product_type product_type){
        productService.deleteproducttype(product_type);
    }

    @PostMapping(value = "/deleteproducts_EN")
    @ResponseBody
    public void deleteproducts(@RequestBody List<Product> products){//将字符串转为json数据
        productService.deleteproducts(products);
    }
}
