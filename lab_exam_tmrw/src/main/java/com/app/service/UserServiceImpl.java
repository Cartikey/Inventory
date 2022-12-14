package com.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.entities.User;

@Service // mandatory : to tell SC , following is spring bean : containing B.L
@Transactional // mandatory to tell SC : to manage txs , auto . using spring supplied tx
				// manager bean , configured in hib persistence xml file
public class UserServiceImpl implements IUserService {
	// dependency : dao i/f
	@Autowired
	private IUserDao userDao;
	@Override
	public User addUser(@Valid User usr) {
		System.out.println("inside userService"+usr);
		return userDao.save(usr);
	}

	@Override
	public User authenticateUser(String em, String pass) {
		// simply call dao's method for db based authentication
		return userDao.findByEmailAndPassword(em, pass)
				.orElseThrow(() -> new RuntimeException("Invalid email or password"));
	}

	

	
	

}
