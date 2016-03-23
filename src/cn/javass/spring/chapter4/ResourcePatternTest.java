package cn.javass.spring.chapter4;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import junit.framework.Assert;

public class ResourcePatternTest {
	
	@Test
	public void testClasspathPrefix() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		//ֻ����һ������ƥ��Resource,��ͨ��ResourceLoder.getResource���м���
		Resource [] resources =resolver.getResources("classpath:META-INF/INDEX.LIST");;
		Assert.assertEquals(1, resources.length);
		//ֻ����һ��ƥ���Resource����ͨ��Resour...
		resources =resolver.getResources("classpath:META-INF/*.LIST");
		Assert.assertTrue(resources.length==1);
	}

}
