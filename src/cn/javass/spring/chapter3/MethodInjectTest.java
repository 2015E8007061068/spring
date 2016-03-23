package cn.javass.spring.chapter3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class MethodInjectTest {
	
	@Test
	public void testLookup(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("chapter3/lookupMethodInject.xml");
		System.out.println("=======singleton sayHello======");
		HelloApi helloApi1 = context.getBean("helloApi1", HelloApi.class);
		helloApi1.sayHello();
		helloApi1 = context.getBean("helloApi1", HelloApi.class);
		helloApi1.sayHello();
		System.out.println("=======prototype sayHello======");
		HelloApi helloApi2 = context.getBean("helloApi2", HelloApi.class);
		helloApi2.sayHello();
		helloApi2 = context.getBean("helloApi2", HelloApi.class);
		helloApi2.sayHello();
		System.out.println("");
	}

}
