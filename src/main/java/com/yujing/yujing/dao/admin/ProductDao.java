package com.yujing.yujing.dao.admin;

import com.yujing.yujing.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProductDao {
    Integer selectcountproduct();
    List<Product> selectproductlimit(Integer a, Integer b);
    void deleteproduct(Product product);
    void deleteproducts(List<Product> products);
//    List<Product> selectproduct();
    void insertproduct(Product product);
    List<Product_type> selectproducttype();
    void insertproducttype(Product_type product_type);
    void deleteproducttype(Product_type product_type);
    void insertproductdetails(Product_details product_details);
    void insertproductflow(Product_flow product_flow);
    void insertproductimg(Product_img product_img);
    List<Product_flow> selectproductflowid(Integer a);
    List<Product_img> selectproductimgid(Integer a);
    Product_details selectproductdetailsid(Integer a);
}
