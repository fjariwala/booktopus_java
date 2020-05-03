package com.bean.DAO;

import com.bean.Entity.UserDetails;

public interface User_DAO {

	/* Register user method */
	public String registerUser(UserDetails userData);

	/* Login user */
	public UserDetails login(UserDetails userData);

	/* Check wheather the user is registered or not wali method */
	public UserDetails checkUser(UserDetails userData);

	/* This method will be used to Get current user details */
	public UserDetails getIndividualuser(int userId);

}
