package leone.desafio_magalu.config;

import leone.desafio_magalu.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class NotificationTaskScheduler {

    private static final Logger logger = LoggerFactory.getLogger(NotificationTaskScheduler.class);
    private NotificationService notificationService;

    public NotificationTaskScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void runTasks(){
        LocalDateTime dateTime = LocalDateTime.now();
        logger.info("Checking at {}", dateTime);
        notificationService.checkAndSend(dateTime);
    }
}
