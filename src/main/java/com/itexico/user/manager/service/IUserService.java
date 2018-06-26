package com.itexico.user.manager.service;

import java.util.List;

import com.itexico.user.manager.entity.User;

public interface IUserService {
	
	    List<User> getAllUser();
	    User getUserById(int id);
	    boolean addUser(User user);
	    User updateUser(User user);
	    Integer deleteUser(int id);
	
}


  

