package com.souvik.dto;

public class Users {
	private String UserID;
	private String UserPassword;
	private int Usertype;

	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public int getUsertype() {
		return Usertype;
	}
	public void setUsertype(int usertype) {
		Usertype = usertype;
	}

	@Override
	public String toString() {
		return "Users [UserID=" + UserID + ", UserPassword=" + UserPassword + ", Usertype=" + Usertype+"]";
	}
}
