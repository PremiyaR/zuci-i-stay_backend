package com.zuci.ZuciIStay.service;
import com.zuci.ZuciIStay.model.Registration;
import com.zuci.ZuciIStay.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Registration registration=registrationRepository.findByUsername(username);
        System.out.println(registration);
        if (registration==null){
            throw new UsernameNotFoundException("username not exist");
        }
        List<GrantedAuthority> list=registration.getRoles().stream().map(e->new SimpleGrantedAuthority(e.getRoleName())).collect(Collectors.toList());
        return new User(registration.getUsername(),registration.getUserPassword(),list);
    }
}
