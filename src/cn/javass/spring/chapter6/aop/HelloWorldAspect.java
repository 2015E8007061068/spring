package cn.javass.spring.chapter6.aop;

public class HelloWorldAspect {
	
	//前置通知
	public void beforceAdvice(){
		System.out.println("========before advice");
	}
	//后置通知
	public void afterFinallyAdvice(){
		System.out.println("========after fianlly advice");
	}
}
