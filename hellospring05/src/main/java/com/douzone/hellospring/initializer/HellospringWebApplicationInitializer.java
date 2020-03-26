package com.douzone.hellospring.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.hellospirng.config.WebConfig;

public class HellospringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Root Application Context 설정
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web Application Context 설정 
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// 서블릿 매핑
		return new String[] {"/"};
	}

}
