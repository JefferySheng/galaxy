package com.galaxy.framework.core.exception;

import com.galaxy.framework.core.constant.ErrorStatus;

/**
 * 自定义Exception
 * @author chensj
 */

public class BusinessException extends RuntimeException {

    private ErrorStatus errorStatus;

    public BusinessException(ErrorStatus errorStatus) {
        super();
        this.errorStatus = errorStatus;
    }
    public BusinessException(ErrorStatus errorStatus, Throwable cause) {
        super(cause);
        this.errorStatus = errorStatus;
    }

    public BusinessException(ErrorStatus errorStatus, String message) {
        super(message);
        this.errorStatus = errorStatus;
    }
    public BusinessException(ErrorStatus errorStatus, String message, Throwable cause) {
        super(message,cause);
        this.errorStatus = errorStatus;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(ErrorStatus errorStatus) {
        this.errorStatus = errorStatus;
    }
}
