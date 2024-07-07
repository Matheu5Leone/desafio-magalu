package leone.desafio_magalu.service;

import leone.desafio_magalu.model.Notification;
import leone.desafio_magalu.model.StatusNotification;
import leone.desafio_magalu.model.dto.ScheduleNotificationDto;
import leone.desafio_magalu.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto){
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId){
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId){
        var notification = findById(notificationId);
        if (notification.isPresent()) {
            notification.get().setStatus(StatusNotification.Values.CANCELED.toStatusNotification());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime){
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(StatusNotification.Values.PENDING.toStatusNotification(),
                        StatusNotification.Values.ERROR.toStatusNotification()),
                dateTime
        );
        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {

            //TODO AQUI ENTRA A LOGICA DO ENVIO DA NOTIFICAÇÃO COM DESIGN PATTERN


            notification.setStatus(StatusNotification.Values.SUCCESS.toStatusNotification());
            notificationRepository.save(notification);
        };
    }
}
