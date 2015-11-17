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
		ssa.setUsername(user.getUser());
		ssa.setPassword(user.getPassword());
		ssa.setInitialSize(1);
		ssa.setMaxActive(20);
		ssa.setMinIdle(0);
		ssa.setMaxWait(60000);
		ssa.setValidationQuery("SELECT 1");
		ssa.setTestOnBorrow(false);
		ssa.setTestWhileIdle(true);
		ssa.setPoolPreparedStatements(false);
		DataSourceContextHolder.clearDataSource();
		DataSourceContextHolder.setThreadDataSource("dataSource1"); 
		dynamicdatasource.addDataSource("dataSource1", ssa);
		logger.info(JSON.toJSONString(userMapper.selectByPrimaryKey(1))+"===========================================");
		DataSourceContextHolder.clearDataSource();
		user = dateBaseMapper.selectByPrimaryKey(2);
		logger.info(JSON.toJSONString(user));
		logger.info(JSON.toJSONString(userMapper.selectByPrimaryKey(1)));
		ssa = new DruidDataSource();
		ssa.setUrl(user.getUrl());
		ssa.setUsername(user.getUser());
		ssa.setPassword(user.getPassword());
		ssa.setInitialSize(1);
		ssa.setMaxActive(20);
		ssa.setMinIdle(0);
		ssa.setMaxWait(60000);
		ssa.setValidationQuery("SELECT 1");
		ssa.setTestOnBorrow(false);
		ssa.setTestWhileIdle(true);
		ssa.setPoolPreparedStatements(false);
		DataSourceContextHolder.setThreadDataSource("AA");  
		dynamicdatasource.addDataSource("AA", ssa);
		logger.info(JSON.toJSONString(userMapper.selectByPrimaryKey(1))+"===========================================");
		
	}
}
