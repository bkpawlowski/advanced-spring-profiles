package pl.grizzlysoftware.spring.module;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.grizzlysoftware.spring.module.customer.CustomerModuleTestSuite;
import pl.grizzlysoftware.spring.module.subscription.SubscriptionModuleTestSuite;
import pl.grizzlysoftware.spring.module.swagger.SwaggerModuleTestSuite;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CustomerModuleTestSuite.class,
        SubscriptionModuleTestSuite.class,
        SwaggerModuleTestSuite.class
})
public class ModuleTestSuite {
}
