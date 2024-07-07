package leone.desafio_magalu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StatusNotification {
    @Id
    private Long statusId;
    private String description;

    public StatusNotification() {

    }

    public StatusNotification(Long id, String description) {
        this.statusId = id;
        this.description = description;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values{
        PENDING(1L,"pending"),
        SUCCESS(2L,"success"),
        CANCELED(3L,"canceled"),
        REJECTED(4L,"rejected"),
        ERROR(5L,"error");
        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public StatusNotification toStatusNotification(){
            return new StatusNotification(id, description);
        }
    }
}
