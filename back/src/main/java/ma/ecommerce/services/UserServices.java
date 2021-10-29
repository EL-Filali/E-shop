package ma.ecommerce.services;

import ma.ecommerce.beans.Product;
import ma.ecommerce.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    ProductRepo productRepo;

    public Page<Product> getAllProducts(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return productRepo.findAll(paging);
    }

    public Product getProductById(Long id) throws Exception {

        Optional<Product> optional =productRepo.findById(id);
        if(optional.isPresent())
            return optional.get();
        else
            throw new Exception("Not Found");
    }

}
