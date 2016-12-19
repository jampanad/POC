package com.nisum.test.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
@Configuration
@RefreshScope
public class ServiceMessages {
	
	@Value("${studentService}")
	private String studentUrl;

	public String getStudentUrl() {
		return studentUrl;
	}

	public void setStudentUrl(String studentUrl) {
		this.studentUrl = studentUrl;
	}
	
}
