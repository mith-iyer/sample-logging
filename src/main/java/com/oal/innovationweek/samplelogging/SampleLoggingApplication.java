package com.oal.innovationweek.samplelogging;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SampleLoggingApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SampleLoggingApplication().configure(new SpringApplicationBuilder(SampleLoggingApplication.class)).run(args);
	}
}
