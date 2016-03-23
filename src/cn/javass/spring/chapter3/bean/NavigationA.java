package cn.javass.spring.chapter3.bean;

public class NavigationA {
	
	private NavigationB navigationB;
	public void setNavigationB(NavigationB navigation){
		this.navigationB=navigation;
		
	}
	public NavigationB getNavigationB(){
		return navigationB;
	}
}
