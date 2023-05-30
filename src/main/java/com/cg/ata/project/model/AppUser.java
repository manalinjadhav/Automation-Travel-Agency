package com.cg.ata.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "app_users") 
public class AppUser {

	@Id
	@Column(name = "user_name")
	@NotBlank
	private String userName;

	@Column(name = "password")
	@NotBlank
	@Min(4)
	@Max(32)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
	private String password;

	@Column(name = "role")
	private Role role;

	public AppUser() {
		super();
	}

	public AppUser(String userName, String password, Role role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}

















//package com.cg.ata.project.model;
//
//import java.sql.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//
//@Entity
//@Table(name = "user_table")
//public class User {
//
//	@Column(name = "name")
//	@NotBlank
//	private String name;
//
//	@Id
//	@Column(name = "mobile")
//	@Pattern(regexp = "^[0-9]{10}$")
//	private String mobileNumber;
//
//	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")
//	private String password;
//
//	@Column(name = "DOB")
//	private Date dob;
//
//	@Column(name = "Address")
//	private String address;
//
//	@Column(name = "Email")
//	private String email;
//
//	@Column(name = "Gender")
//	private String gender;
//
//	@Column(name = "role")
//	private Role role;
//
//	public User() {
//		super();
//
//	}
//
//	public User(String name, String mobileNumber, String password) {
//		super();
//		this.name = name;
//		this.mobileNumber = mobileNumber;
//		this.password = password;
//	}
//
//	public User(String mobileNumber, String password) {
//		super();
//
//		this.mobileNumber = mobileNumber;
//		this.password = password;
//
//	}
//
//	public User(String name, String mobileNumber, String password, Date dob, String address, String email,
//			String gender, Role role) {
//		super();
//		this.name = name;
//		this.mobileNumber = mobileNumber;
//		this.password = password;
//		this.dob = dob;
//		this.address = address;
//		this.email = email;
//		this.gender = gender;
//		this.role = role;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getMobileNumber() {
//		return mobileNumber;
//	}
//
//	public void setMobileNumber(String mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Date getDob() {
//		return dob;
//	}
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	@Override
//	public String toString() {
//		return "User [name=" + name + ", mobileNumber=" + mobileNumber + ", password=" + password + ", dob=" + dob
//				+ ", address=" + address + ", email=" + email + ", gender=" + gender + ",role=" + role + "]";
//	}
//
//}
