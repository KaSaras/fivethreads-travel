package lt.fivethreads.entities.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class EditTripInformation {
    @NotNull(message = "ID cannot be null.")
    private Long id;
    @NotNull(message="Start date cannot be null.")
    @DateTimeFormat
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    private Date startDate;
    @DateTimeFormat
    @NotNull(message="Finish date cannot be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    private Date finishDate;
    @NotNull(message="Arrival cannot be null.")
    private FullAddressDTO arrival;
    @NotNull(message="Departure cannot be null.")
    private FullAddressDTO departure;
}
