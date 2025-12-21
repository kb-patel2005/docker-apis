package com.ecommarce.demo.dao;

import java.io.IOException;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommarce.demo.entity.Product;

import jakarta.servlet.annotation.MultipartConfig;

@Service
@MultipartConfig
public class ProductServiceImplementation implements ProductServices {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public List<Product> getall() {
        List<Product> products = productRepo.findAll();
        return products;
    }

    @Override
    public Product updateProduct(String pTitle, String userName, String password) {
        String uid = productRepo.searchByUsernameAndPassword(userName, password);
        Product p = productRepo.searchProduct(pTitle, uid);
        return p;
    }

    @Override
    public void delete(String pTitle, String userName, String password) {
        String uid = productRepo.searchByUsernameAndPassword(userName, password);
        Product p = productRepo.searchProduct(pTitle, uid);
        productRepo.delete(p);
    }

    @Override
    public void add(Product p, MultipartFile image) {
        try {

            ObjectId fileId = gridFsTemplate.store(
                    image.getInputStream(),
                    image.getOriginalFilename(),
                    image.getContentType());

            p.setImgName(image.getOriginalFilename());
            p.setImgContentType(image.getContentType());
            p.setImagedetail(fileId.toString());

            productRepo.save(p);

        } catch (IOException e) {
            System.out.println("Error saving product: " + e.getMessage());
        }
    }

    @Override
    public void setimage(Product p, MultipartFile image) {
        try {
            ObjectId fileId = gridFsTemplate.store(
                    image.getInputStream(),
                    image.getOriginalFilename(),
                    image.getContentType());

            if (p != null) {
                p.setImgName(image.getOriginalFilename());
                p.setImgContentType(image.getContentType());
                p.setImagedetail(fileId.toString());
            }

            productRepo.save(p);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Product getById(String Id){
        return productRepo.findById(Id).orElse(null);
    }

}
