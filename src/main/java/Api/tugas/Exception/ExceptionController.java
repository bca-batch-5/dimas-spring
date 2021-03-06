package Api.tugas.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    private ErrorMessage errorMessage;
    
    // Global Exxception
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessage> globalException(Exception exception) {
        errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), exception.getMessage());
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);
    }
    // not found exception
    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<ErrorMessage> dataNotFound(DataNotFoundException exception) {
        errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), exception.getMessage());
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);
    }
}
