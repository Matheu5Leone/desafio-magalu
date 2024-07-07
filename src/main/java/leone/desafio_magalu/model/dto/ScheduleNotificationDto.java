package leone.desafio_magalu.model.dto;

import leone.desafio_magalu.model.Channel;
import leone.desafio_magalu.model.Notification;
import leone.desafio_magalu.model.StatusNotification;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {

    public Notification toNotification(){
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                StatusNotification.Values.PENDING.toStatusNotification()
        );
    }

}
