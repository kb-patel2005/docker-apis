package com.ecommarce.demo.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ecommarce.demo.dao.ProductRepo;
import com.ecommarce.demo.dao.ProductServices;
import com.ecommarce.demo.dao.UserRepo;
import com.ecommarce.demo.entity.Product;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin("*")
@MultipartConfig
public class ProductController {

    @Autowired
    ProductRepo prepo;

    @Autowired
    ProductServices service;

    @Autowired
    UserRepo urepo;

    // done..........
    @GetMapping("/cart/{productId}")
    public Product getProductByProductId(@PathVariable("productId") String productId) {
        return service.getById(productId);
    }

    // done..........
    @PostMapping("/add/{uid}")
    public Product setProductdata(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("qty") int qty,
            @RequestPart("image") MultipartFile image,
            @PathVariable("uid") String uid) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setQty(qty);
        product.setEcommarceUser(uid);
        service.add(product, image);
        prepo.save(product);
        return product;
    }

    @GetMapping("/image/{id}")
public ResponseEntity<?> getImage(@PathVariable String id) {
    try {
        GridFsResource resource = (GridFsResource) service.getImage(id);
        if (resource == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(resource.getContentType()))
                .body(resource.getInputStream().readAllBytes());
    } catch (IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error retrieving image");
    }
}


    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestBody Product p) {
        prepo.deleteById(p.getpId());
        return "delete product";
    }

    // @GetMapping("/all")
    // public List<Product> getallownproduct(HttpServletRequest req) {
    // Cookie c[] = req.getCookies();
    // String uid;
    // for (Cookie c1 : c) {
    // if (c1.getName().equals("email")) {
    // String val = c1.getValue();
    // uid = prepo.searchByUserId(val);
    // return prepo.searchProducts(uid);
    // }
    // }
    // return null;
    // }

    @GetMapping("/products")
    public Page<Product> getAllProducts(Pageable pageable) {
        return prepo.findAll(pageable);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product p) {
        prepo.save(p);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> setemailproduct(@PathVariable("id") String id) {
        return prepo.findById(id);
    }

}
