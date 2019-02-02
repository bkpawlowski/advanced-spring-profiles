package pl.grizzlysoftware.spring.asp.api.module.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@Configuration
@ComponentScan
@Profile("security-module")
public class SecurityModuleConfiguration {
}
