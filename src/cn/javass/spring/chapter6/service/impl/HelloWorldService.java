package cn.javass.spring.chapter6.service.impl;

import cn.javass.spring.chapter6.service.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {
	@Override
	public void sayHello(){
		System.out.println("========Hello World!");
	}
}
