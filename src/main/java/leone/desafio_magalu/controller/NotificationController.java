package leone.desafio_magalu.controller;

import leone.desafio_magalu.model.Notification;
import leone.desafio_magalu.model.dto.ScheduleNotificationDto;
import leone.desafio_magalu.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/")
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto dto){
        notificationService.scheduleNotification(dto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable Long notificationId){
        var notification = notificationService.findById(notificationId);
        if (notification.isEmpty())
            return ResponseEntity.status(404).build();

        return ResponseEntity.status(200).body(notification.get());
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable Long notificationId){
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.status(204).build();
    }
}
