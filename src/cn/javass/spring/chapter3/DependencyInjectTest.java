package cn.javass.spring.chapter3;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class DependencyInjectTest {
	
	@Test 
	public void testConstructorDenpendencyInjectTest(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/beanInject.xml");
//		//获取根据参数索引依赖注入的bean
//		HelloApi byIndex = beanFactory.getBean("bean", HelloApi.class);
//		byIndex.sayHello();
//		//获取根据参数类型依赖注入的Bean
//		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
//		byType.sayHello();
//		//获取根据参数名字依赖注入的Bean
//		HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
//		byName.sayHello();
		HelloApi bean1 =beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
		
	}

}
