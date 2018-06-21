package com.itexico.user.manager.dao;

import java.util.List;

import com.itexico.user.manager.entity.User;

public interface IUserDAO {
    List<User> getAllUser();
    User getUserById(int id);
    User addUser(User user);
    User updateUser(User user);
    Integer deleteUser(int id);
	boolean userExists(String name, String password);
} 
