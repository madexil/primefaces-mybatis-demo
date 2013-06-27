package net.demo.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1604108597590078429L;
	private Long id;
	private String userId;
	private String password;
	private String firstName;
	private String lastName;	
	private String updateBy;
	private Date createDate;
	private Date updateDate;
	public User() {
		super();
	}

	public User(Long id, String userId, String password, String firstName,
			String lastName) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", updateBy=" + updateBy + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

	public String getUpdateBy() {
		return updateBy;
	}
	
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
		
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
