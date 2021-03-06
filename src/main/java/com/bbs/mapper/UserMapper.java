package com.bbs.mapper;

import com.bbs.entity.User;
import com.bbs.entity.UserExample;
import com.bbs.entity.UserPrincipal;
import com.bbs.vo.VUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	long countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	User selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	int updateByPrimaryKey(User record);

	UserPrincipal selectByUsername(String username);
	
	void lockUserByUsername(String username);
	
	void unlockUserByUsername(String username);
	
	List<UserPrincipal> selectAllUser();
	
	List<User> selectAllUserLikeUsername(String username);
	
	VUser selectVUser(@Param("id") Long id, @Param("username") String username);
	int countByUsername(String username);
	
	UserPrincipal selectUserById(long userId);
}