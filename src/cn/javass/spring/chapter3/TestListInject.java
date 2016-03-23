package cn.javass.spring.chapter3;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter3.bean.ListTestBean;
import junit.framework.Assert;

public class TestListInject {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testListInject(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/listInject.xml");
		ListTestBean listBean = beanFactory.getBean("listBean", ListTestBean.class);
		System.out.println(listBean.getValues().size());
		Assert.assertEquals(3, listBean.getValues().size());
	}

}
