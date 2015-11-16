package com.ssmm.dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.ssmm.model.DateBase;
import com.ssmm.util.DataSourceContextHolder;
import com.ssmm.util.DynamicDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestUserDao {
	private static final Logger logger = Logger
			.getLogger(TestUserDao.class);

	@Autowired
	private DateBaseMapper dateBaseMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Autowired
	private DynamicDataSource dynamicdatasource;

	public DateBaseMapper getUserMapper() { 
		return dateBaseMapper;
	}

	public void setUserMapper(DateBaseMapper dateBaseMapper) {
		this.dateBaseMapper = dateBaseMapper;
	}
	
	@Test
	public void getUserById() {
		DateBase user = dateBaseMapper.selectByPrimaryKey(1);
		logger.info(JSON.toJSONString(user));
		logger.info(JSON.toJSONString(userMapper.selectByPrimaryKey(1)));
		DruidDataSource ssa = new DruidDataSource();
		ssa.setUrl(user.getUrl());
		ssa.setUsername(ssa.getUsername());
		ssa.setPassword(user.getPassword());
		ssa.setDriverClassName("com.mysql.jdbc.Driver");
		dynamicdatasource.addDataSource("dataSource1", ssa);
		DataSourceContextHolder.setThreadDataSource("dataSource1"); 
		logger.info(JSON.toJSONString(userMapper.selectByPrimaryKey(1))+"===========================================");
		dynamicdatasource.addDataSource("AA", ssa);
		DataSourceContextHolder.setThreadDataSource("AA");  
		logger.info(JSON.toJSONString(userMapper.selectByPrimaryKey(1))+"===========================================");
		
	}
}
