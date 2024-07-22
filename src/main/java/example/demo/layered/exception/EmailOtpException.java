package example.demo.layered.exception;

import example.common.exception.support.CustomException;
import example.common.exception.support.ErrorCode;

public class EmailOtpException extends CustomException {
    public EmailOtpException() {
        super();
    }

    public EmailOtpException(String message) {
        super(message);
    }

    public EmailOtpException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailOtpException(ErrorCode errorCode) {
        super(errorCode);
    }

    public EmailOtpException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
