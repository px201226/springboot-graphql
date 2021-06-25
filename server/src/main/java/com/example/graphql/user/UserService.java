package com.example.graphql.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByName(username).orElseThrow(RuntimeException::new);
        return new PrincipleUser(user);
    }

    public User findByUserName(String userName){
        User user = userRepository.findByName(userName).orElseThrow(RuntimeException::new);
        return user;
    }
}
