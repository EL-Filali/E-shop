package ma.ecommerce.services;

import ma.ecommerce.beans.User;
import ma.ecommerce.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsServices implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepo.findByEmail(email);
        if(user==null)
            throw new UsernameNotFoundException("User not found");
        else
            return user;
    }


    public User loadUserById(Long userId) {
        Optional<User> optional=userRepo.findById(userId);
        if(optional.isPresent())
            return optional.get();
        else
            throw new UsernameNotFoundException("User not found");
    }
}
