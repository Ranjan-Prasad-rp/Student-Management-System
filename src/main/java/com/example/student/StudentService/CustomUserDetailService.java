package com.example.student.StudentService;

import com.example.student.StudentRepository.StudentLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

@Autowired
    private   StudentLoginRepo studentLoginRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentLoginRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


    }

}
