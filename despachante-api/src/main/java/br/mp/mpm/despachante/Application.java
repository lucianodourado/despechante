package br.mp.mpm.despachante;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
@EnableSpringDataWebSupport
@EnableCaching
@EnableScheduling
@EnableSwagger2
public class Application {

	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		SpringApplication.run(Application.class, args);
	}

}
