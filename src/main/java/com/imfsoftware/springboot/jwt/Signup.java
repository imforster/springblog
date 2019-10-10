package com.imfsoftware.springboot.jwt;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.imfsoftware.springboot.jwt.auth.User;

public class Signup {
	@NotNull
	@Size(min=2,max=64)
	private String firstName;
	@NotNull
	@Size(min=2,max=64)
	private String lastName;
	@NotNull
	@Size(min=6,max=128)
	private String userName;
	@NotNull
	@Size(min=8,max=256)
	private String password;
	@NotNull
	@Size(min=8,max=256)
	private String confirmpassword;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public boolean comparePasswords() {
		if (confirmpassword.equals(password)) {
			return true;
		}
		return false;
	}
	
	public User toUser() {
		User newuser = new User();
		newuser.setFirstName(this.firstName);
		newuser.setLastName(this.lastName);
		newuser.setUsername(this.userName);
		newuser.setPassword(BCrypt.hashpw(this.getPassword(), BCrypt.gensalt(11)));
		return newuser;
	}
	
	@Override
	public String toString() {
		return "Signup [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", confirmpassword=" + confirmpassword + "]";
	}	
}
