package com.bbs.entity;

import com.fasterxml.jackson.annotation.JsonView;

public class User {
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	@JsonView(SimpleUser.class)
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.username
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	@JsonView(SimpleUser.class)
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.password
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	@JsonView(CompleteUser.class)
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.credit
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	@JsonView(SimpleUser.class)
	private Integer credit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.lock_type
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	@JsonView(SimpleUser.class)
	private Boolean lockType;
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.id
	 * @return  the value of t_user.id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Long getId() {
		return id;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.id
	 * @param id  the value for t_user.id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.username
	 * @return  the value of t_user.username
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.username
	 * @param username  the value for t_user.username
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.password
	 * @return  the value of t_user.password
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.password
	 * @param password  the value for t_user.password
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.credit
	 * @return  the value of t_user.credit
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Integer getCredit() {
		return credit;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.credit
	 * @param credit  the value for t_user.credit
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.lock_type
	 * @return  the value of t_user.lock_type
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Boolean getLockType() {
		return lockType;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.lock_type
	 * @param lockType  the value for t_user.lock_type
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setLockType(Boolean lockType) {
		this.lockType = lockType;
	}
	public interface SimpleUser{};
	
	public interface CompleteUser extends SimpleUser{};
	public String toString() {
		return username;
	}
}