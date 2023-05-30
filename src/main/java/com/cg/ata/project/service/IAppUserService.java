package com.cg.ata.project.service;

import java.util.List;

import com.cg.ata.project.model.AppUser;



public interface IAppUserService {

	public abstract List<AppUser> getAllUsers();

	public abstract AppUser registerUser(AppUser user);

	public abstract AppUser loginUser(AppUser user);

	public abstract String logoutUser(String userName);

	public abstract AppUser updateUser(AppUser user);

}









//package com.cg.ata.project.service;
//
//import com.cg.ata.project.exception.InvalidLogin;
//import com.cg.ata.project.model.Role;
//import com.cg.ata.project.model.User;
//
//public interface IUserService {
//	
//       public User validateLogin(String mobileNumber,String password,Role role) throws InvalidLogin;
//		public User registerUser(User user);
//
//	}
