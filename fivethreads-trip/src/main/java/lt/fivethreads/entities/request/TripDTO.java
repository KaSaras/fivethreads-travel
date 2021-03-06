package lt.fivethreads.entities.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TripDTO {
    @NotNull(message = "ID cannot be null.")
    private Long id;
    @NotNull(message="Start date cannot be null.")
    private Date startDate;
    @NotNull(message="Finish date cannot be null.")
    private Date finishDate;
    @NotNull(message="Arrival cannot be null.")
    private FullAddressDTO arrival;
    @NotNull(message="Departure cannot be null.")
    private FullAddressDTO departure;
    private List<TripMemberDTO> tripMembers;
    @NotNull(message="Organizer cannot be null.")
    private String organizer_email;
    @NotNull(message = "Is flexible cannot be null.")
    private Boolean isFlexible;
    @NotNull(message = "IsCombined cannot be null")
    private Boolean isCombined;
    private String tripStatus;
    private String purpose;
}
