package com.test.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.test.entities.User;
@Service("userService")
public interface UserService {

	public List<User> findAllUsers();

	public User findById(long id);

	public boolean isUserExist(User user);

	public void saveUser(User user);

	public void updateUser(User currentUser);

	public void deleteUserById(long id);

	public void deleteAllUsers() ;
		
	
	
	


}
