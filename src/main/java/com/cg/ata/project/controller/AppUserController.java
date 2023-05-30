package com.cg.ata.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ata.project.model.AppUser;
import com.cg.ata.project.service.AppUserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class AppUserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AppUserServiceImpl userService;

//======================================================================================
	@GetMapping("/get-all-users")
	public ResponseEntity<List<AppUser>> getAllUsers() {
		LOG.info("get-all-appUsers");
		return new ResponseEntity<List<AppUser>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
//======================================================================================
	@PostMapping("/register")
	public ResponseEntity<AppUser> register(@RequestBody AppUser user) {
		LOG.info(user.toString());
		return new ResponseEntity<AppUser>(userService.registerUser(user), HttpStatus.CREATED);
	}
	
//========================================================================================
	@PostMapping("/login")
	public ResponseEntity<AppUser> login(@RequestBody AppUser user) {
		LOG.info(user.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User " + user.getUserName() + " logged in successfully.");
		return new ResponseEntity<AppUser>(userService.loginUser(user), headers, HttpStatus.OK);
	}
	
//=======================================================================================
	@GetMapping("/logout/{user}")
	public ResponseEntity<String> logout(@PathVariable(name = "user") String userName) {
    return new ResponseEntity<String>(userService.logoutUser(userName), HttpStatus.OK);
	}
	
//======================================================================================
	@PutMapping("/update-user")
	public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser user) {
		LOG.info(user.toString());
		return new ResponseEntity<AppUser>(userService.updateUser(user), HttpStatus.OK);
	}
}















//package com.cg.ata.project.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import com.cg.ata.project.model.Role;
//import com.cg.ata.project.model.User;
//import com.cg.ata.project.service.UserServiceImpl;
//
//
////*Controller Class for User Controller
////Author : kapil  moin
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//	@Autowired
//	UserServiceImpl use;
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	/*
//	 *  registerUser 
//	 */
//
//	@PostMapping("user/register")
//	public ResponseEntity<User> registerUser(@RequestBody User user) {
//		LOG.info(user.toString());
//		return new ResponseEntity<User>(use.registerUser(user), HttpStatus.CREATED);
//	}
//
//	/*
//	 *  user Login 
//	 */
//
//	@GetMapping("user/validation")
//	public ResponseEntity<User> validateLogin(@RequestParam("mno") String mno, @RequestParam("pass") String pass,
//			@RequestParam("role") Role role) {
//		return new ResponseEntity<>(use.validateLogin(mno, pass, role), HttpStatus.OK);
//
//	}
//
//}
