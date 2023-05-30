//package com.cg.ata.project;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import com.cg.ata.project.model.User;
//import com.cg.ata.project.repository.UserRepository;
//import com.cg.ata.project.service.UserServiceImpl;
//
//@SpringBootTest
//class UserTest {
//
//	@Autowired
//	UserRepository urepo;
//
//	@Autowired
//	UserServiceImpl service;
//
//	@Test
//	void validateLoginTest() {
//
//		User u = new User( "1234567890", "Shan@123");
//
//		assertNotNull(urepo.validateLogin(u.getMobileNumber(), u.getPassword()));
//		assertEquals(u.getPassword(), urepo.validateLogin(u.getMobileNumber(), u.getPassword()).getPassword());
//
//	}
//
//}
