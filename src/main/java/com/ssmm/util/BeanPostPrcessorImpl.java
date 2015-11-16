package com.ssmm.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.alibaba.druid.pool.DruidDataSource;

public class BeanPostPrcessorImpl implements BeanPostProcessor {
	@Autowired 
	private DynamicDataSource tradingRoutingDataSource;
	private static Map<Object,Object> _targetDataSources =new HashMap<Object, Object>();

	public Object postProcessBeforeInitialization(Object bean, String beanName)
		throws BeansException {
			if(bean instanceof DruidDataSource){
			_targetDataSources.put(beanName, bean);
			tradingRoutingDataSource.setTargetDataSources(_targetDataSources);
			}
			return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}
}
