package cn.javass.spring.chapter6.aop;

public class HelloWorldAspect {
	
	//ǰ��֪ͨ
	public void beforceAdvice(){
		System.out.println("========before advice");
	}
	//����֪ͨ
	public void afterFinallyAdvice(){
		System.out.println("========after fianlly advice");
	}
}
