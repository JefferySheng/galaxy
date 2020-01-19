package com.galaxy.framework.core.rest;

import com.galaxy.framework.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

/**
 * @author aaron.pan
 * @date 2018/5/23
 */
@ControllerAdvice
public class ErrorControllerAdvice {

    private Logger log = LoggerFactory.getLogger(ErrorControllerAdvice.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus
    public Result exceptionHandler(Exception e) {
        log.info(e.getMessage());
        return Result.buildFailure(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Result runtimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();
        String msg = e.getMessage();
        return Result.buildFailure(HttpStatus.BAD_REQUEST.value(), msg);
    }

    /**
     * 处理'@Valid'注解验证实体出错
     *
     * @param e MethodArgumentNotValidException
     * @return 错误提示
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for (Iterator<FieldError> it = result.getFieldErrors().iterator(); it.hasNext(); ) {
            FieldError fieldError = it.next();
            sb.append(fieldError.getField());
            sb.append(fieldError.getDefaultMessage());
            if (it.hasNext()) {
                sb.append(";");
            }
        }
        log.error(e.toString() + "result>>" + sb.toString());
        return Result.buildFailure(sb.toString());
    }

    /**
     * 自定义异常通用处理方式
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Result handleApiException(BusinessException e) {
        String message = e.getMessage();
        int code = e.getErrorStatus().value();
        log.error(e.toString() + "result>>errorCode=" + code);
        if (StringUtils.isEmpty(message)) {
            return Result.buildFailure(code);
        }
        return Result.buildFailure(code, message);
    }

}