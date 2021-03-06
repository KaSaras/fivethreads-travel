package lt.fivethreads.entities.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class CarTicketDTO {

    @DateTimeFormat
    @NotNull(message = "Car Rent Start cannot be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    private Date carRentStart;

    @DateTimeFormat
    @NotNull(message = "Car Rent Finish cannot be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    private Date carRentFinish;

    private double price;

    private List<FileDTO> files = new ArrayList<>();
}
