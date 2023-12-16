package com.javamaster.transport;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;


@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Transportation API", version = "1.0", description = "Documentation Transportation API v1.0"))
@SpringBootApplication
public class CaseStudyTransportationApplication {
	private static final Logger logger = Logger.getLogger(CaseStudyTransportationApplication.class.getName());


	public static void main(String[] args) {
			SpringApplication.run(CaseStudyTransportationApplication.class, args);

	}

}
