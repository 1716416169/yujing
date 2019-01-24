package com.yujing.yujing.pojo;

import java.util.List;

public class Product {
    private Integer id;
    private String name;
    private String price;
    private String batch_quantity;
    private String guide;
    private String parameterimg;
    private Integer type;
    private Product_details product_details;
    private List<Product_flow> product_flows;
    private List<Product_img> product_imgs;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBatch_quantity() {
        return batch_quantity;
    }

    public void setBatch_quantity(String batch_quantity) {
        this.batch_quantity = batch_quantity;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public Product_details getProduct_details() {
        return product_details;
    }

    public void setProduct_details(Product_details product_details) {
        this.product_details = product_details;
    }

    public List<Product_flow> getProduct_flows() {
        return product_flows;
    }

    public void setProduct_flows(List<Product_flow> product_flows) {
        this.product_flows = product_flows;
    }

    public List<Product_img> getProduct_imgs() {
        return product_imgs;
    }

    public void setProduct_imgs(List<Product_img> product_imgs) {
        this.product_imgs = product_imgs;
    }

    public String getParameterimg() {
        return parameterimg;
    }

    public void setParameterimg(String parameterimg) {
        this.parameterimg = parameterimg;
    }
}
