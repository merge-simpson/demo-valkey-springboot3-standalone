package example.common.exception;

import example.common.exception.response.ApiResponseError;
import example.common.exception.support.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponseError> handleMemberException(CustomException exception) {
        ApiResponseError response = ApiResponseError.of(exception);
        HttpStatus httpStatus = exception
                .getErrorCode()
                .defaultHttpStatus();

        return ResponseEntity
                .status(httpStatus)
                .body(response);
    }
}
