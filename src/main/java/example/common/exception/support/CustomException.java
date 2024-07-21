package example.common.exception.support;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    protected final ErrorCode errorCode;

    public CustomException() {
        super(DefaultErrorCodeHolder.Default_Error_Code.defaultMessage());
        this.errorCode = DefaultErrorCodeHolder.Default_Error_Code;
    }
    public CustomException(String message) {
        super(message);
        this.errorCode = getDefaultErrorCode(message);
    }
    public CustomException(String message, Throwable cause) {
        super(message,cause);
        this.errorCode = getDefaultErrorCode(message,cause);
    }
    public CustomException(ErrorCode errorCode) {
        super(errorCode.defaultMessage());
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.defaultMessage(),cause);
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }

    // 익명 객체
    private static ErrorCode getDefaultErrorCode() {
        return getDefaultErrorCode("오류발생");
    }

    private static ErrorCode getDefaultErrorCode(String message) {
        return getDefaultErrorCode(message,null);
    }

    private static ErrorCode getDefaultErrorCode(String message, Throwable cause) {
        return new ErrorCode(){

            @Override
            public String name() {
                return "DEFAULT_ERROR_CODE";
            }

            @Override
            public String defaultMessage() {
                return message;
            }

            @Override
            public HttpStatus defaultHttpStatus() {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public RuntimeException defaultException() {
                return cause==null? new CustomException(this):new CustomException(this,cause);
            }

            @Override
            public RuntimeException defaultException(Throwable cause) {
                return new CustomException(this,cause);
            }


        };
    }

    private static class DefaultErrorCodeHolder{

        private static final ErrorCode Default_Error_Code = CustomException.getDefaultErrorCode();

    }
}