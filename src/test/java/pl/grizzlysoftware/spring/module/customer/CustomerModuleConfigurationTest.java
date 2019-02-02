package pl.grizzlysoftware.spring.module.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.grizzlysoftware.spring.asp.api.module.customer.CustomerModuleConfiguration;
import pl.grizzlysoftware.spring.asp.api.module.customer.resource.CustomerResource;
import pl.grizzlysoftware.spring.asp.api.module.customer.resource.PremiumCustomerResource;
import pl.grizzlysoftware.spring.asp.api.module.customer.service.CustomerService;
import pl.grizzlysoftware.spring.utils.DummyConfiguration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pl.grizzlysoftware.spring.utils.ConfigurationTestUtils.naiveBeanName;
import static pl.grizzlysoftware.spring.utils.ConfigurationTestUtils.startApplicationContext;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@RunWith(JUnit4.class)
public class CustomerModuleConfigurationTest {

    @Test
    public void doesNotLoadAnyBeansFromThePackage() {
        var ctx = startApplicationContext(new Class[]{CustomerModuleConfiguration.class}, "some-profile");
        assertFalse(ctx.containsBean(naiveBeanName(CustomerModuleConfiguration.class)));
        assertFalse(ctx.containsBean(naiveBeanName(CustomerService.class)));
        assertFalse(ctx.containsBean(naiveBeanName(CustomerResource.class)));
        assertFalse(ctx.containsBean(naiveBeanName(PremiumCustomerResource.class)));

        //different configuration class
        ctx = startApplicationContext(new Class[]{DummyConfiguration.class}, "some-profile");
        assertFalse(ctx.containsBean(naiveBeanName(CustomerModuleConfiguration.class)));
        assertFalse(ctx.containsBean(naiveBeanName(CustomerService.class)));
        assertFalse(ctx.containsBean(naiveBeanName(CustomerResource.class)));
        assertFalse(ctx.containsBean(naiveBeanName(PremiumCustomerResource.class)));
    }

    @Test
    public void doesLoadOnlyCustomerConfigurationAndCustomerServiceBean() {
        var ctx = startApplicationContext(new Class[]{CustomerModuleConfiguration.class}, "customer-module");
        assertTrue(ctx.containsBean(naiveBeanName(CustomerModuleConfiguration.class)));
        assertTrue(ctx.containsBean(naiveBeanName(CustomerService.class)));
        assertFalse(ctx.containsBean(naiveBeanName(CustomerResource.class)));
        assertFalse(ctx.containsBean(naiveBeanName(PremiumCustomerResource.class)));
    }

    @Test
    public void doesLoadOnlyCustomerServiceAndCustomerResourceBeans() {
        var ctx = startApplicationContext(new Class[]{CustomerModuleConfiguration.class}, "customer-module", "customer-module.resource");
        assertTrue(ctx.containsBean(naiveBeanName(CustomerModuleConfiguration.class)));
        assertTrue(ctx.containsBean(naiveBeanName(CustomerService.class)));
        assertTrue(ctx.containsBean(naiveBeanName(CustomerResource.class)));
        assertFalse(ctx.containsBean(naiveBeanName(PremiumCustomerResource.class)));
    }

    @Test
    public void doesLoadAllRequiredBeans() {
        var ctx = startApplicationContext(new Class[]{CustomerModuleConfiguration.class}, "customer-module", "customer-module.resource", "customer-module.premium-resource");
        assertTrue(ctx.containsBean(naiveBeanName(CustomerModuleConfiguration.class)));
        assertTrue(ctx.containsBean(naiveBeanName(CustomerService.class)));
        assertTrue(ctx.containsBean(naiveBeanName(CustomerResource.class)));
        assertTrue(ctx.containsBean(naiveBeanName(PremiumCustomerResource.class)));
    }
}
