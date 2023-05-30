package com.cg.ata.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ata.project.model.AppUser;



@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

}


















//
//package com.cg.ata.project.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import com.cg.ata.project.model.User;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, String> {
//	
//	@Query(value="SELECT * from user_table u where u.mobile = ?1 AND password=?2", nativeQuery = true)
//	public User validateLogin(String mobileNumber,String password);
//	
//	@Query(value = "select * from user_table where mobile =?1",nativeQuery = true)
//	public User findOne(String mobileNo);
//}
// 