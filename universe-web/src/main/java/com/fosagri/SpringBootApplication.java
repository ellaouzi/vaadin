package com.fosagri;

 import com.fosagri.rest.TesterClass;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.fosagri"})
@EnableJpaRepositories({"com.fosagri"})
@EntityScan(("com.fosagri"))
public class SpringBootApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		TesterClass testClass=new TesterClass();
		testClass.testMethod();
		return application.sources(SpringBootApplication.class);
	}
	
	public static void main(String [] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

}
