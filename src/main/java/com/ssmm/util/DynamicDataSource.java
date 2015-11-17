package com.ssmm.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.alibaba.druid.pool.DruidDataSource;


public class DynamicDataSource extends AbstractRoutingDataSource{
	
	@Override
	protected Object determineCurrentLookupKey() {
	return DataSourceContextHolder.getThreadDataSource();
	}

	@Override
	    public void setTargetDataSources(Map<Object, Object> targetDataSources) {  
	        super.setTargetDataSources(targetDataSources);  
	        afterPropertiesSet();
	    }  
    
    /**@author qilin**/  
    public void addDataSource(Object key,Object dataSource){  
    	Map<Object, Object> sours = new HashMap<Object,Object>();
    	sours.put(key, dataSource);
//    	setDefaultTargetDataSource(SpringUtil.getBeanById("dataSource"));
        setTargetDataSources(sours);  
        
        
    }
}
