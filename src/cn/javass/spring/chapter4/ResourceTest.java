package cn.javass.spring.chapter4;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import junit.framework.Assert;

public class ResourceTest {
	
	@Test
	public void testByteArrayResource(){
		Resource resource = new ByteArrayResource("Hello world!".getBytes());
		if (resource.exists()){
			dumpStream(resource);
		}
	}
	
	@Test
	public void testInputStreamResource(){
		ByteArrayInputStream bis = new ByteArrayInputStream("Hello World".getBytes());
		Resource resource = new InputStreamResource(bis);
		if (resource.exists()){
			
			dumpStream(resource);
		}
		Assert.assertEquals(true, resource.isOpen());
	}
	
	@Test
	public void testFileResource(){
		File file = new File("d:/test.txt");
			Resource resource = new FileSystemResource(file);
			if(resource.exists()){
				dumpStream(resource);
			}
			Assert.assertEquals(false, resource.isOpen());
	}
	
	@Test
	public void testClasspathResourceByDefaultClassLoader() throws IOException{
		Resource resource = new ClassPathResource("cn/javass/spring/chapter4/test1.properties");
		if(resource.exists()){
			dumpStream(resource);
		}
		System.out.println("path"+resource.getFile().getAbsolutePath());
		Assert.assertEquals(false, resource.isOpen());
		
	}
	
	@Test
	public void testClasspathResourceByClassLoader() throws IOException{
		ClassLoader c1 = this.getClass().getClassLoader();
		Resource resource = new ClassPathResource("cn/javass/spring/chapter4/test1.properties",c1);
		if(resource.exists()){
			dumpStream(resource);
		}
		System.out.println("path"+resource.getFile().getAbsolutePath());
		Assert.assertEquals(false, resource.isOpen());
	}
	private void dumpStream(Resource resource) {
		InputStream is =null;
		
		try{
			//获取文件资源
			is = resource.getInputStream();
			//读取文件资源
			byte[] descBytes = new byte[is.available()];
			is.read(descBytes);
			System.out.println(new String(descBytes));
			
		} catch(IOException e){
			e.printStackTrace();
		}
		
		finally{
			try{
				//关闭资源
				is.close();
			} catch(IOException e){
				
			}
			
		}
		
	}

}
