package lt.bit.s4h.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	   Docket api() {
	       return new Docket(DocumentationType.SWAGGER_2)
	               .useDefaultResponseMessages(false)
	               .groupName("all")
	               .select()
	               .apis(RequestHandlerSelectors.basePackage(""))
	               .paths(PathSelectors.any())
	               .build().pathMapping("/")
	               .directModelSubstitute(LocalDate.class, String.class)
	               .directModelSubstitute(LocalDateTime.class, String.class)
	               .enable(Boolean.valueOf(true))
	               .apiInfo(apiInfo());
	   }
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("From Configuration").build();
	}
}
