package com.chana.beans;

import java.util.List;

public class UserList {
	List<User> users;

	public UserList(List<User> users) {
		this.users = users;
	}

	public UserList() {
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
