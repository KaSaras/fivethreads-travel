package lt.fivethreads.entities.request;

import lombok.Getter;
import lombok.Setter;
import lt.fivethreads.entities.TripAcceptance;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TripMemberDTO {
    @NotNull(message="Email cannot be null.")
    @Email(message="Wrong email format.")
    private String email;

    private Long id;

    @NotNull
    private Boolean isFlightTickedNeeded;

    @NotNull
    private Boolean isAccommodationNeeded;

    @NotNull
    private Boolean isCarNeeded;

    private FlightTicketDTO flightTicketDTO;

    private CarTicketDTO carTicketDTO;

    private AccommodationDTO accommodationDTO;

    private TripAcceptance status;

    private String cancellation;
}
