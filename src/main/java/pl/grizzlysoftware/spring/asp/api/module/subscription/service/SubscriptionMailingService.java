package pl.grizzlysoftware.spring.asp.api.module.subscription.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@Service
@Profile("subscription-module.mailing-service")
@EnableScheduling
public class SubscriptionMailingService {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionMailingService.class);

    @Scheduled(fixedDelay = 5_000)
    public void sendPromotionEmail() {
        logger.info("Pretending to be an e-mail sender...");
    }
}
