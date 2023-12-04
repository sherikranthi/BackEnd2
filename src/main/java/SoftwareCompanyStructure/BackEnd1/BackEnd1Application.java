package SoftwareCompanyStructure.BackEnd1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(
		info = @Info(
				title = "Software Company Structure",
				version = "1.0.0",
				description = "The below are the Rest API endpoints used in this project"
		)
)

public class BackEnd1Application {

	public static void main(String[] args) {
		SpringApplication.run(BackEnd1Application.class, args);
	}

}
