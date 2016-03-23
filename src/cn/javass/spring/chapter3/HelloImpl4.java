package cn.javass.spring.chapter3;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class HelloImpl4 implements HelloApi{

	private String message;
	private int index;
	//setter·½·¨
	public void setMessage(String messgae){
		this.message=messgae;
	}
	
	public void setIndex(int index){
		this.index=index;
	}
	@Override
	public void sayHello() {
		System.out.println(index+":"+message);
	}
	
}
