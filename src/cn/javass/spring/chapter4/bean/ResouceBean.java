package cn.javass.spring.chapter4.bean;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class ResouceBean implements ResourceLoaderAware {
	private ResourceLoader resourceLoder;

	public ResourceLoader getResourceLoder() {
		return resourceLoder;
	}

	

	@Override
	public void setResourceLoader(ResourceLoader resourceLoder) {
		// TODO Auto-generated method stub
		this.resourceLoder = resourceLoder;
	}
	
	

}
