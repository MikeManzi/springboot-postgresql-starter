package com.example.springbootstarter.controllers;

import com.example.springbootstarter.dtos.SignUpDTO;
import com.example.springbootstarter.exceptions.BadRequestException;
import com.example.springbootstarter.models.Role;
import com.example.springbootstarter.models.User;
import com.example.springbootstarter.payload.ApiResponse;
import com.example.springbootstarter.repositories.IRoleRepository;
import com.example.springbootstarter.repositories.IUserRepository;
import com.example.springbootstarter.security.JwtTokenProvider;
import com.example.springbootstarter.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody SignUpDTO dto){
        if(dto.getEmail() != null && userRepository.existsByEmail(dto.getEmail())){
            throw new BadRequestException("Email already in use!");
        }
        if(dto.getMobile() !=null && userRepository.existsByMobile(dto.getMobile())){
            throw new BadRequestException("Phone number already in use");
        }
        Role role = roleRepository.findByName(dto.getRole()).orElseThrow(
                ()-> new BadRequestException("User Role not set"));

        User user = new User();

        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setMobile(dto.getMobile());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(Collections.singleton(role));

        User createdUser = userService.create(user);

        return ResponseEntity.ok(new ApiResponse(true, createdUser));

    }
}
