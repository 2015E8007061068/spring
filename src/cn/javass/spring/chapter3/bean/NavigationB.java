package cn.javass.spring.chapter3.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class NavigationB {
	private NavigationC navigationC;
	private List<NavigationC> list;
	private Properties properties;
	private NavigationC[] array =new NavigationC[1];
	private Map<String, NavigationC> map;
} 
