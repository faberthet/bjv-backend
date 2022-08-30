package com.bjv.bjvbackend.admin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminModel {
	
	@Id
	private String adminId;
	private String password;
	
	public AdminModel() {}
	
	public AdminModel(String adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getAdminId() +" " + this.getPassword();
	}
	
	

}
