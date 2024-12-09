package com.example.ludotheque.security;

import com.example.ludotheque.dal.IUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoUserDetailsServiceImpl implements UserDetailsService {
    private final IUserRepository userRepository;
    public DemoUserDetailsServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.getByLogin(username);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            return User.builder().username(user.getUsername()).password(user.getPassword()).authorities(user.getAuthorities()).build();
        }

        throw new UsernameNotFoundException("User not found");

    }
}
