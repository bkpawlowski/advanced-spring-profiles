package pl.grizzlysoftware.spring.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.StandardEnvironment;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
public class ConfigurationTestUtils {

    public static ApplicationContext startApplicationContext(Class<?>[] configurationClasses, String... profiles) {
        var env = new StandardEnvironment();
        env.setActiveProfiles(profiles);
        var ctx = new AnnotationConfigApplicationContext();
        ctx.setEnvironment(env);
        ctx.register(configurationClasses);
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
