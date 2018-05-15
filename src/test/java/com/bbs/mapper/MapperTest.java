package com.bbs.mapper;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbs.base.BaseJunit4Test;
import com.bbs.entity.Permission;
import com.bbs.entity.Role;

public class MapperTest extends BaseJunit4Test {

	private static final Logger logger = Logger.getLogger(MapperTest.class);
	
	@Autowired
	PermissionMapper permissionMapper;
	
	@Autowired
	RoleMapper roleMapper;
	
	@Test
	public void testMapper() {
		List<Role> roles = roleMapper.selectAll(1L);
		
		logger.info("取出的roles: " + roles);
		
		List<Permission> perms = permissionMapper.selectAll(1L);
		
		logger.info("取出的permissions： " + perms);
	}
}
