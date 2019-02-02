package pl.grizzlysoftware.spring.asp.api.module.subscription.resource;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@RestController
@RequestMapping("/subscription")
@Profile("subscription-module.resource")
public class SubscriptionResource {
}
