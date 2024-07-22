package example.demo.layered.exception;

import example.common.exception.support.ErrorCode;
import org.springframework.http.HttpStatus;

public enum EmailOtpErrorCode implements ErrorCode {
    OTP_NOT_FOUND("잘못된 인증 번호입니다.", HttpStatus.NOT_FOUND),
    EMAIL_OTP_NOT_FOUND("이 이메일로 등록된 OTP가 없습니다.", HttpStatus.NOT_FOUND),
    ;

    private final String message;
    private final HttpStatus status;

    EmailOtpErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String defaultMessage() {
        return message;
    }

    @Override
    public HttpStatus defaultHttpStatus() {
        return status;
    }

    @Override
    public EmailOtpException defaultException() {
        return new EmailOtpException(this);
    }

    @Override
    public EmailOtpException defaultException(Throwable cause) {
        return new EmailOtpException(this, cause);
    }
}
