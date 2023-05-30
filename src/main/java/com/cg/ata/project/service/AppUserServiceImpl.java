package com.cg.ata.project.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ata.project.exception.AppUserAlreadyExistsException;
import com.cg.ata.project.exception.AppUserNotFoundException;
import com.cg.ata.project.model.AppUser;

import com.cg.ata.project.repository.AppUserRepository;



@Service
public class AppUserServiceImpl implements IAppUserService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppUserRepository userRepository;

	AppUser loggedInUser;

	@Override
	public List<AppUser> getAllUsers() {
		List<AppUser> userList = userRepository.findAll();
		if (userList.isEmpty()) {
			String exceptionMessage = "Users don't exist in the database.";
			LOG.warn(exceptionMessage);
			throw new AppUserNotFoundException(exceptionMessage);
		} else {
			LOG.info("userList returned successfully.");
			return userList;
		}
	}

	@Override
	public AppUser registerUser(AppUser user) {
		LOG.info(user.toString());
		Optional<AppUser> userOptional = userRepository.findById(user.getUserName());
		if (userOptional.isEmpty()) {
			return userRepository.save(user);
		} else {
			String exceptionMessage = "User with userName " + user.getUserName() + " already exists.";
			throw new AppUserAlreadyExistsException(exceptionMessage);
		}
	}

	@Override
	public AppUser loginUser(AppUser user) {
		LOG.info(user.toString());
		Optional<AppUser> userOptional = userRepository.findById(user.getUserName());
		if (userOptional.isPresent()) {
			if (user.equals(userOptional.get())) {
				LOG.info(userOptional.get().toString());
				loggedInUser = user; // successful login
				return user;
			} else {
				String exceptionMessage = "Wrong password!";
				LOG.warn(exceptionMessage);
				throw new AppUserNotFoundException(exceptionMessage);
			}
		} else {
			String exceptionMessage = "Wrong userName!";
			LOG.warn(exceptionMessage);
			throw new AppUserNotFoundException(exceptionMessage);
		}
	}

	@Override
	public String logoutUser(String userName) {
		if (loggedInUser.getUserName().equals(userName)) {
			LOG.info(userName + " logged out successfully.");
			loggedInUser = null;
			return userName;
		} else {
			String exceptionMessage = "User with userName " + userName + " is not logged in.";
			LOG.warn(exceptionMessage);
			throw new AppUserNotFoundException("This Name User Not Found");
		}
	}

	@Override
	public AppUser updateUser(AppUser user) {
		Optional<AppUser> userOptional = userRepository.findById(user.getUserName());
		if (userOptional.isPresent()) {
			LOG.info(userOptional.get().toString());
			return userRepository.save(user);
		} else {
			String exceptionMessage = "User with userName " + user.getUserName() + " not found!";
			LOG.warn(exceptionMessage);
			throw new AppUserNotFoundException(exceptionMessage);
		}
	}
}













//package com.cg.ata.project.service;
//
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.cg.ata.project.exception.AccountAlreadyExistsException;
//import com.cg.ata.project.exception.InvalidLogin;
//import com.cg.ata.project.model.Role;
//import com.cg.ata.project.model.User;
//import com.cg.ata.project.repository.UserRepository;
//
//
//@Service
//public class UserServiceImpl implements IUserService {
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private UserRepository userRepository;
//
//	/**************** validation ******************/
//	@Override
//	public User validateLogin(String mobileNumber, String password, Role role) {
//
//		User user = userRepository.validateLogin(mobileNumber, password);
//		if (user != null) {
//			LOG.info("Validation Done");
//			return user;
//		} else
//			throw new InvalidLogin("Invalid Credentials");
//
//	}
//
//	/******************** register *******************/
//	@Override
//	public User registerUser(User user) {
//		LOG.info(user.toString());
//		Optional<User> userOptional = userRepository.findById(user.getMobileNumber());
//		if (userOptional.isEmpty()) {
//			return userRepository.save(user);
//		} else {
//			String exceptionMessage = "User with mobileNumber" + user.getMobileNumber() + " already exists.";
//			throw new AccountAlreadyExistsException(exceptionMessage);
//		}
//	}
//
//}
