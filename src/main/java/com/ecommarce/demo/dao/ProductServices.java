package com.ecommarce.demo.dao;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.ecommarce.demo.entity.Product;

public interface ProductServices{
    public List<Product> getall();

    public Product updateProduct(String pTitle,String userName,String password); 

    public void delete(String pTitle,String userName,String password);

    public void add(Product p,MultipartFile image);

    public void setimage(Product p,MultipartFile img);

    public Product getById(String Id);

    public Object getImage(String id);

}
