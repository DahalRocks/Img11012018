package com.dhruba.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserDetail userFromDatabase;

	public boolean exists(User user) {
		return userDao.exists(user);
	}

	public boolean saveUser(User user) {
		boolean isSaved = true;
		try {
			userDao.saveUser(user);
		} catch (DataAccessException e) {
			isSaved = false;

		}
		return isSaved;
	}

	public boolean login(User user) {
		boolean isOK = true;
		try {
			if (!userDao.login(user))
				isOK = false;
		} catch (DataAccessException e) {
			isOK = false;

		}
		return isOK;
	}

	public User getUserDetailByName(User user) {
		user = userDao.getUserDetailByName(user);
		return user;
	}

	public List<User> getUserList() {
		List<User> lstUser = new ArrayList<User>();

		try {
			lstUser = userDao.getUserList();
		} catch (DataAccessException e) {

		}

		return lstUser;
	}

	public boolean updateUserReminder(User user) {
		boolean isUpdated = true;
		try {
			if (userDao.updateUserReminder(user) < 1)
				isUpdated = false;
		} catch (DataAccessException e) {

			isUpdated = false;
		}
		return isUpdated;
	}

	
	public boolean checkIfUserExist(UserDetail userDetail){
		boolean isExist=false;
		try {
			if(userDao.checkUserDetail(userDetail))
				isExist=true;
				
		} catch (DataAccessException e) {
			System.out.println("message from checkIfUserExist:"+e.getMessage());
		}
		return isExist;
	}
	
	public int enterUserDetail(UserDetail userDetail) {
		int result=0;
		try {
			result=userDao.saveUserDetail(userDetail);

		} catch (DataAccessException e) {
			System.out.println("message from enterUserDetail:"+e.getMessage());
			
		}
		return result;
	}
	
	public UserDetail getUserDetailId(UserDetail userDetail){
		try {
			userFromDatabase=userDao.getUserDetailId(userDetail);
		} catch (DataAccessException e) {
			System.out.println("message from getUserDEtailId:"+e.getMessage());
		}
		return userFromDatabase;
		
	}
	
}
