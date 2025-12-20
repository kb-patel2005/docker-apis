package com.ecommarce.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

    @Id
    private String pId;
    private String title;
    private String description;
    private int qty;
    private int price;
    private String imgname;
    private String imgcontenttype;
    private String imagedetail;
    private String userId;

    public String getImgName() {
        return imgname;
    }

    public void setImgName(String imgName) {
        this.imgname = imgName;
    }

    public String getImgContentType() {
        return imgcontenttype;
    }

    public void setImgContentType(String imgContentType) {
        this.imgcontenttype = imgContentType;
    }

    public String getImagedetail() {
        return imagedetail;
    }

    public void setImagedetail(String imagedetail) {
        this.imagedetail = imagedetail;
    }

    public Product() {
    }

    public Product(String pId,String title,String description,int qty,int price,String user,String imgname,String imgcontenttype,String imagedetail) {
        this.pId = pId;
        this.title = title;
        this.description = description;
        this.qty = qty;
        this.price = price;
        this.userId = user;
        this.imgname = imgname;
        this.imgcontenttype = imgcontenttype;
        this.imagedetail = imagedetail;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUser() {
        return userId;
    }

    public void setEcommarceUser(String user) {
        this.userId = user;
    }

    @Override
    public String toString() {
        return "Product [pId=" + pId + ", title=" + title + ", description=" + description + ", qty=" + qty + ", price="
                + price + ", user=" + userId + ", imgname=" + imgname + ", imgcontenttype=" + imgcontenttype
                + ", imagedetail=" + imagedetail
              + "]";
    }

}
