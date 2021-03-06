package lt.fivethreads.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "User was modified by other user.")
public class UserWasModified extends RuntimeException {
}
