package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.entities.User;

public interface IUserService {
	User authenticateUser(String em, String pass);

	User addUser(@Valid User usr);
	
	
}
