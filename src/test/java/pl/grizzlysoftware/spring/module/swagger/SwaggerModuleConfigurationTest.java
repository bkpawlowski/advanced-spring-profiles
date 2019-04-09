package pl.grizzlysoftware.spring.module.swagger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.grizzlysoftware.spring.asp.api.module.swagger.SwaggerModuleConfiguration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pl.grizzlysoftware.spring.utils.ConfigurationTestUtils.naiveBeanName;
import static pl.grizzlysoftware.spring.utils.ConfigurationTestUtils.startWebApplicationContext;

/**
 * Created by Bartosz Pawłowski on 2019-04-08.
 */
@RunWith(JUnit4.class)
public class SwaggerModuleConfigurationTest {
    @Test
    public void doesNotLoadAllRequiredBeans() {
        //swagger2 needs web application context in order to be created
        var ctx = startWebApplicationContext(new Class[]{SwaggerModuleConfiguration.class}, "some-profile");
        assertFalse(ctx.containsBean(naiveBeanName(SwaggerModuleConfiguration.class)));
        assertFalse(ctx.containsBean("swagger2ControllerMapping"));
    }

    @Test
    public void doesLoadAllRequiredBeans() {
        //swagger2 needs web application context in order to be created
        var ctx = startWebApplicationContext(new Class[]{SwaggerModuleConfiguration.class}, "swagger-module");
        assertTrue(ctx.containsBean(naiveBeanName(SwaggerModuleConfiguration.class)));
        assertTrue(ctx.containsBean("swagger2ControllerMapping"));
    }
}
