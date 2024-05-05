package com.example.backend.services;

import com.example.backend.models.Users;

import java.util.List;

public interface UsersService {
    Users addUser(Users users);

    List<Users> getListUsers();

    Users findUserById(Long searchedId);

    void deleteUser(Long id);

    void updateUser(Users user);
}
