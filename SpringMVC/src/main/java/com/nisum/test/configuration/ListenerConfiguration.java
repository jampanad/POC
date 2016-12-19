package com.nisum.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
public class ListenerConfiguration {

	 @Bean 
	 public RequestContextListener requestContextListener(){
		    return new RequestContextListener();
		} 
}
