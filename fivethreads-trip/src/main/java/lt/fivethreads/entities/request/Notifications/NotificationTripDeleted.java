package lt.fivethreads.entities.request.Notifications;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class NotificationTripDeleted {
    @NotNull(message = "ID cannot be null.")
    private Long id;
    @NotNull (message = "IsActive cannot be null.")
    private Boolean isActive;
    private String notificationType;
    @NotNull (message = "Created Date cannot be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "CET")
    private Date created_date;
    @NotNull (message = "Name cannot be null.")
    private String name;
    @NotNull (message = "Organizer cannot be null.")
    private UserInformationDTO organizer;
    @NotNull (message = "Trip ID cannot be null.")
    private Long trip_id;
    @NotNull (message = "Trip start date cannot be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    private Date startDate;
    @NotNull (message = "Trip finish date cannot be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    private Date finishDate;
    @NotNull (message = "Trip arrival cannot be null.")
    private String arrival;
    @NotNull (message = "Trip departure cannot be null.")
    private String departure;
    private String purpose;
}
