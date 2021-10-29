package ma.ecommerce.services;

import ma.ecommerce.beans.Product;
import ma.ecommerce.beans.ProductBuilder;
import ma.ecommerce.beans.User;
import ma.ecommerce.dto.ConnexionRequest;
import ma.ecommerce.dto.ConnexionResponse;
import ma.ecommerce.repositories.ProductRepo;
import ma.ecommerce.repositories.UserRepo;
import ma.ecommerce.securityConfig.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorServices {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Value("${security.token_prefix}")
    private String TOKEN_PREFIX;


    public  void initDatabase() {
        ProductBuilder productBuilder=new ProductBuilder();
        List<Product> productList=new ArrayList<>();
        productList.add(productBuilder.setName("shoes")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi non quis exercitationem " +
                        "culpa nesciunt nihil aut nostrum explicabo reprehenderit optio amet ab temporibus" +
                        " asperiores quasi cupiditate. Voluptatum ducimus voluptates voluptas?")
                .setImgUrl("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8cHJvZHVjdHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60")
                .setPrice(50)
                .setCountInStock(20)
                .build());
        productList.add(productBuilder.setName("Phone")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi non quis exercitationem" +
                        " culpa nesciunt nihil aut nostrum explicabo reprehenderit optio amet ab temporibus asperiores quasi" +
                        " cupiditate. Voluptatum ducimus voluptates voluptas?")
                .setImgUrl("https://images.unsplash.com/photo-1485955900006-10f4d324d411?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTN8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60")
                .setPrice(20)
                .setCountInStock(10)
                .build());
        productList.add(productBuilder.setName("Laptop")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi non quis exercitationem" +
                        " culpa nesciunt nihil aut nostrum explicabo reprehenderit optio amet ab temporibus asperiores quasi" +
                        " cupiditate. Voluptatum ducimus voluptates voluptas?")
                .setImgUrl("https://images.unsplash.com/photo-1581235720704-06d3acfcb36f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fHByb2R1Y3R8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60")
                .setPrice(13.23f)
                .setCountInStock(14)
                .build());
        productList.add(productBuilder.setName("pen")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi non quis exercitationem" +
                        " culpa nesciunt nihil aut nostrum explicabo reprehenderit optio amet ab temporibus asperiores quasi" +
                        " cupiditate. Voluptatum ducimus voluptates voluptas?")
                .setImgUrl("https://images.unsplash.com/photo-1586495777744-4413f21062fa?ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8cHJvZHVjdHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60")
                .setPrice(24.02f)
                .setCountInStock(2)
                .build());
        productList.add(productBuilder.setName("preaqsd")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi non quis exercitationem" +
                        " culpa nesciunt nihil aut nostrum explicabo reprehenderit optio amet ab temporibus asperiores quasi" +
                        " cupiditate. Voluptatum ducimus voluptates voluptas?")
                .setImgUrl("https://images.unsplash.com/photo-1572635196237-14b3f281503f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8cHJvZHVjdHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60")
                .setPrice(24.02f)
                .setCountInStock(2)
                .build());
        productRepo.saveAll(productList);

    }

    public ConnexionResponse  connexion(ConnexionRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);
        User user = (User) authentication.getPrincipal();
        ConnexionResponse connexionResponse =new ConnexionResponse(jwt, user);
        return connexionResponse;
    }




    public ConnexionResponse register(User user){
        String password=new String(user.getPassword()) ;
        String email=new String(user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);
        User userConnected = (User) authentication.getPrincipal();
        ConnexionResponse connexionResponse =new ConnexionResponse(jwt, userConnected);
        return connexionResponse;
    }
}
