package org.ac.cst8277.kwok_szeman;

import org.ac.cst8277.kwok_szeman.db1.entity.User;
import org.ac.cst8277.kwok_szeman.db1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserManagementService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), "", new ArrayList<>());
    }

    public String initiateOAuth() {
        UUID state = UUID.randomUUID(); // Using UUID for state
        String authorizationUrl = "https://authorization-server.com/oauth/authorize" +
                "?response_type=code" +
                "&client_id=" + "XXXXXXX" +
                "&redirect_uri=" + "http://localhost:8080/login/oauth2/code/github" +
                "&state=" + state.toString() +
                "&scope=user";
        return authorizationUrl;
    }

}
