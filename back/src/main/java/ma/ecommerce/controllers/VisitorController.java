package ma.ecommerce.controllers;

import ma.ecommerce.beans.User;
import ma.ecommerce.dto.ConnexionRequest;
import ma.ecommerce.dto.ConnexionResponse;
import ma.ecommerce.services.VisitorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
public class VisitorController {

    @Autowired
    VisitorServices visitorServices;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("login")
    public ResponseEntity<?> connexion(@RequestBody ConnexionRequest request){
        System.out.println(request.getEmail() + request.getPassword());
        ConnexionResponse response=visitorServices.connexion(request);
        return new ResponseEntity(response, HttpStatus.OK);

    }


    @PostMapping("register")
    public ResponseEntity<?> inscription(@RequestBody User user ){

        ConnexionResponse response=  visitorServices.register(user);
        return new ResponseEntity(response,HttpStatus.OK);

    }

    @PostMapping("a")
    public ResponseEntity<?> setUpDB( ){
        visitorServices.initDatabase();
        return new ResponseEntity(HttpStatus.OK);

    }
}
