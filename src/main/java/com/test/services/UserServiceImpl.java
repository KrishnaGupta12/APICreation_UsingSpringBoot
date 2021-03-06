package com.test.services;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.test.entities.User;



@Service("userService")
public class UserServiceImpl implements UserService{
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static{
		makeDummyData();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId((int) counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<User> iter = users.iterator(); iter.hasNext(); ) {
		    User user = iter.next();
		    if (user.getId() == id) {
		    	iter.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static void makeDummyData(){
		List<User> userList = new ArrayList<User>();
		userList.add(new User((int)counter.incrementAndGet(),"David","jan@123","krishna123"));
		userList.add(new User((int)counter.incrementAndGet(),"Catherine","ranjan@124","ranjan12"));
		userList.add(new User((int)counter.incrementAndGet(),"Pax","hari@123","hari12"));
		users = userList;
	}

}
