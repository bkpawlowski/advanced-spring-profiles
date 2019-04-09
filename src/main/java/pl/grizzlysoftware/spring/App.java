package pl.grizzlysoftware.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.grizzlysoftware.spring.asp.api.module.ApiModulesConfiguration;
import pl.grizzlysoftware.spring.core.SpringCoreConfiguration;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@Configuration
@Import({SpringCoreConfiguration.class, ApiModulesConfiguration.class})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
