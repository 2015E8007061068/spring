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
		//只加载一个绝对匹配Resource,且通过ResourceLoder.getResource进行加载
		Resource [] resources =resolver.getResources("classpath:META-INF/INDEX.LIST");;
		Assert.assertEquals(1, resources.length);
		//只加载一个匹配的Resource，且通过Resour...
		resources =resolver.getResources("classpath:META-INF/*.LIST");
		Assert.assertTrue(resources.length==1);
	}

}
