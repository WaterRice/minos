package org.wingsOfHope.minos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class MinosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinosApplication.class, args);
	}
	
	@Bean
	public ConfigurableServletWebServerFactory containerCustomizer() {
	  TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
	  factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/index.html"));
	  return factory;
	}
	
}
