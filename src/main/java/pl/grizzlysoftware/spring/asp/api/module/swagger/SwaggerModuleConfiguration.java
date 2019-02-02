package pl.grizzlysoftware.spring.asp.api.module.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Bartosz Pawłowski on 2019-03-29.
 */
@Configuration
@EnableSwagger2
@Profile("swagger-module")
public class SwaggerModuleConfiguration {
}
