package pl.grizzlysoftware.spring.module.subscription;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.grizzlysoftware.spring.asp.api.module.subscription.SubscriptionModuleConfiguration;
import pl.grizzlysoftware.spring.asp.api.module.subscription.resource.SubscriptionResource;
import pl.grizzlysoftware.spring.asp.api.module.subscription.service.SubscriptionMailingService;
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
public class SubscriptionModuleConfigurationTest {

    @Test
    public void doesNotLoadAnyBeansFromThePackage() {
        var ctx = startApplicationContext(new Class[]{SubscriptionModuleConfiguration.class}, "some-profile");
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionModuleConfiguration.class)));
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionMailingService.class)));
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionResource.class)));

        //different configuration class
        ctx = startApplicationContext(new Class[]{DummyConfiguration.class}, "some-profile");
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionModuleConfiguration.class)));
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionMailingService.class)));
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionResource.class)));
    }

    @Test
    public void doesLoadConfigurationBean() {
        var ctx = startApplicationContext(new Class[]{SubscriptionModuleConfiguration.class}, "subscription-module");
        assertTrue(ctx.containsBean(naiveBeanName(SubscriptionModuleConfiguration.class)));
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionMailingService.class)));
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionResource.class)));
    }

    @Test
    public void doesLoadSubscriptionMailingServiceBean() {
        var ctx = startApplicationContext(new Class[]{SubscriptionModuleConfiguration.class}, "subscription-module", "subscription-module.mailing-service");
        assertTrue(ctx.containsBean(naiveBeanName(SubscriptionModuleConfiguration.class)));
        assertTrue(ctx.containsBean(naiveBeanName(SubscriptionMailingService.class)));
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionResource.class)));
    }

    @Test
    public void doesLoadSubscriptionResourceBean() {
        var ctx = startApplicationContext(new Class[]{SubscriptionModuleConfiguration.class}, "subscription-module", "subscription-module.resource");
        assertTrue(ctx.containsBean(naiveBeanName(SubscriptionModuleConfiguration.class)));
        assertFalse(ctx.containsBean(naiveBeanName(SubscriptionMailingService.class)));
        assertTrue(ctx.containsBean(naiveBeanName(SubscriptionResource.class)));
    }

    @Test
    public void doesLoadAllRequiredBeans() {
        var ctx = startApplicationContext(new Class[]{SubscriptionModuleConfiguration.class}, "subscription-module", "subscription-module.mailing-service", "subscription-module.resource");
        assertTrue(ctx.containsBean(naiveBeanName(SubscriptionModuleConfiguration.class)));
        assertTrue(ctx.containsBean(naiveBeanName(SubscriptionMailingService.class)));
        assertTrue(ctx.containsBean(naiveBeanName(SubscriptionResource.class)));
    }
}
