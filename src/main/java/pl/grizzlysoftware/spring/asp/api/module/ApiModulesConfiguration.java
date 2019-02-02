package pl.grizzlysoftware.spring.asp.api.module;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.grizzlysoftware.spring.asp.api.module.customer.CustomerModuleConfiguration;
import pl.grizzlysoftware.spring.asp.api.module.security.SecurityModuleConfiguration;
import pl.grizzlysoftware.spring.asp.api.module.subscription.SubscriptionModuleConfiguration;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@Import({
        SecurityModuleConfiguration.class,
        CustomerModuleConfiguration.class,
        SubscriptionModuleConfiguration.class
})
@Configuration
public class ApiModulesConfiguration {

}
