package pl.grizzlysoftware.spring.utils;

import org.apache.catalina.Container;
import org.apache.catalina.core.*;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 * <p>
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
public class ConfigurationTestUtils {

    public static ApplicationContext startWebApplicationContext(Class<?>[] configurationClasses, String... profiles) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        StandardContext sc = new StandardContext();

        StandardContext sc1 = new StandardContext();
        StandardService ss = new StandardService();
        StandardEngine se = new StandardEngine();
        se.setService(ss);
        sc1.setParent(se);
        sc.setParent(sc1);
        ctx.setServletContext(new org.apache.catalina.core.ApplicationContext(sc));
        ctx.register(ServletWebServerFactoryAutoConfiguration.class);
        return startApplicationContext(ctx, configurationClasses, profiles);
    }

    public static ApplicationContext startApplicationContext(Class<?>[] configurationClasses, String... profiles) {
        return startApplicationContext(new AnnotationConfigApplicationContext(), configurationClasses, profiles);
    }

    public static ApplicationContext startApplicationContext(AbstractApplicationContext ctx, Class<?>[] configurationClasses, String... profiles) {
        var env = new StandardEnvironment();
        env.setActiveProfiles(profiles);

        if (ctx instanceof GenericApplicationContext) {
            var ctx0 = (GenericApplicationContext) ctx;
            ctx0.setEnvironment(env);
        }

        if (ctx instanceof AnnotationConfigRegistry) {
            var ctx0 = (AnnotationConfigRegistry) ctx;
            ctx0.register(configurationClasses);
        }

        ctx.setEnvironment(env);
        ctx.refresh();

        return ctx;
    }

    public static String naiveBeanName(Class<?> clazz) {
        String beanName = clazz.getSimpleName();
        String firstLetter = beanName.substring(0, 1);
        beanName = beanName.replaceFirst(firstLetter, firstLetter.toLowerCase());
        return beanName;
    }
}
