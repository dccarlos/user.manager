package com.itexico.user.manager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itexico.user.manager.dao.IUserDAO;
import com.itexico.user.manager.entity.User;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public User getUserById(int id) {
		User obj = userDAO.getUserById(id);
		return obj;
	}	
	@Override
	public List<User> getAllUser(){
		return userDAO.getAllUser();
	}
	@Override
	public synchronized boolean addUser(User user){
                if (userDAO.userExists(user.getName(), user.getPassword())) {
    	          return false;
                } else {
    	          userDAO.addUser(user);
    	          return true;
                }
	}
	@Override
	public User updateUser(User user) {
		return userDAO.updateUser(user);		
	}
	@Override
	public Integer deleteUser(int id) {
		return userDAO.deleteUser(id);
	
	}
}
