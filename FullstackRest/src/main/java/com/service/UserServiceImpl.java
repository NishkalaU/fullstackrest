package com.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.User;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	
    @Transactional
	@Override
	public User createUser(User user) {
		
		User user2 = null;
		if(user.getPassword().length() > 2)
		{
			System.out.println("validation successfull");
			user2 = this.userDao.createUser(user);
		}
		return user2;
	}

	@Override
	public List<User> readUser() {
		return this.userDao.readUser();
		
	}

	@Override
	public User readUserById(int userId) {
		
		return this.userDao.readUserById(userId);
	}

	@Override
	public User readUserByName(int userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User deleteUserById(int userId) {
	return	this.userDao.deleteUserById(userId);
	
	}

}
