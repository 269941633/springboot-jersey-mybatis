package com.springboot;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;



public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(RequestContextFilter.class);
		packages("com.salt.api.reportmanage.provider");
	}
}