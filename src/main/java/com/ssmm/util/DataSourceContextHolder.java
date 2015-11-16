package com.ssmm.util;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.ssmm.dao.TestUserDao;

public class DataSourceContextHolder {
	private static final Logger logger = Logger
			.getLogger(DataSourceContextHolder.class);


	 private static final ThreadLocal contextHolder=new ThreadLocal(); 


	public static String getThreadDataSource() {
	String dataSourceName = (String) contextHolder.get();
	if (dataSourceName != null) {
	logger.info("DataSource Name:[" + dataSourceName + "]");
	}
	return (String) contextHolder.get();
	}


	public static void setThreadDataSource(String dataSourceName) {
		contextHolder.set(dataSourceName);
	}
}
