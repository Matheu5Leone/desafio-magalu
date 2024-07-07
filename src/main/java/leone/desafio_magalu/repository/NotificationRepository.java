package leone.desafio_magalu.repository;

import leone.desafio_magalu.model.Notification;
import leone.desafio_magalu.model.StatusNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<StatusNotification> status, LocalDateTime dateTime);
}
