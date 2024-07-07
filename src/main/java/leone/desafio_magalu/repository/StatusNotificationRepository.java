package leone.desafio_magalu.repository;

import leone.desafio_magalu.model.StatusNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusNotificationRepository extends JpaRepository<StatusNotification, Long> {
}
