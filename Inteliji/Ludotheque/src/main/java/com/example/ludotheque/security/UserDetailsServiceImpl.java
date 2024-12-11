package com.example.ludotheque.security;

import com.example.ludotheque.bo.UserApplication;
import com.example.ludotheque.dal.IUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserRepository userRepository;
    public UserDetailsServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserApplication> userOptional = userRepository.getByLogin(username);
        if(userOptional.isPresent()) {
            UserApplication user = userOptional.get();
            List<GrantedAuthority> roles = Arrays.stream(user.getRoles().split(","))
                    .map(role -> new SimpleGrantedAuthority("ROLE_"+role))
                    .collect(Collectors.toList());
            return User.builder().username(user.getLogin()).password(user.getPassword()).authorities(roles).build();
        }

        throw new UsernameNotFoundException("User not found");

    }
}
