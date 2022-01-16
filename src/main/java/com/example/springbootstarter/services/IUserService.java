package com.example.springbootstarter.services;

import com.example.springbootstarter.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User create(User user);
}
