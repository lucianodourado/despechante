package br.mp.mpm.despachante;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.mp.mpm.despachante"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo())				
				// Opção para acrescentar o token de autorização.
		        .securitySchemes(Arrays.asList(apiKey()))	        
		        .securityContexts(Arrays.asList(securityContext()));
	}
	
	
	private ApiKey apiKey() {
        return new ApiKey("Authorization", HttpHeaders.AUTHORIZATION, In.HEADER.name());
    }
	
	private SecurityContext securityContext() {
	    return SecurityContext.builder()
	        .securityReferences(defaultAuth())	        
	        .forPaths(paths())
	        .build();
	}
	
	private Predicate<String> paths() {
		// TODO: automatizar a descoberta dos paths protegidos no contexto
	    return Predicates.or(
		    	PathSelectors.ant("/pessoa"),		    	
	    		PathSelectors.ant("/relatorio/**")		    	
	    );
	}
	
	private List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Compartilhamento de dados corporativos com os ramos do MPU - API REST")
	            .version("1.0.0")
	            //.description("")
	            //.license("Ministério Público Militar - 2019")
	            //.licenseUrl("https://www.mpm.mp.br")
	            //.contact(new Contact("Departamento de Tec. Informação", "", ""))
	            .build();
	}

}
