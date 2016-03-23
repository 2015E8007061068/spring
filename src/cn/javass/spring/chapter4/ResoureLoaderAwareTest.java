package cn.javass.spring.chapter4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import cn.javass.spring.chapter4.bean.ResouceBean;
import junit.framework.Assert;

public class ResoureLoaderAwareTest {

	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter4/resourceLoaderAware.xml");
		ResouceBean resouceBean = ctx.getBean(ResouceBean.class);
		ResourceLoader loader =resouceBean.getResourceLoder();
		Assert.assertTrue(loader instanceof ApplicationContext);;
	}
}
