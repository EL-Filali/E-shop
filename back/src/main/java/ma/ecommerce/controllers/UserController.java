package ma.ecommerce.controllers;

import ma.ecommerce.beans.Product;
import ma.ecommerce.beans.User;
import ma.ecommerce.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServices userServices;
    @GetMapping("/products")
    ResponseEntity<?> getAllProducts(@RequestParam(defaultValue = "0") Integer pageNo,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     @RequestParam(defaultValue = "id") String sortBy, Principal principal){
        System.out.println("q");
    return new ResponseEntity<>(userServices.getAllProducts(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    ResponseEntity<?> getProduct(@PathVariable Long id){
        try {
            Product product =userServices.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

}
