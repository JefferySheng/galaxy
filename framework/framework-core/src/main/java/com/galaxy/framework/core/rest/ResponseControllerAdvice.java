package com.galaxy.framework.core.rest;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @author chensj
 */
@ControllerAdvice
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    private static final String USER_INFO_URI = "/uaa/current";

    private static final String ACCESS_TOKEN_URI = "/uaa/oauth/token";

    private static final String ERROR_URI = "/uaa/error";

    private static final String SWAGGER_URI = "v2/api-docs";

    private static final String SWAGGER_RESOURCE = "/swagger-resources";

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        Method method = returnType.getMethod();
        NoResult methodAnnotation = method.getAnnotation(NoResult.class);
        String requestPath = request.getURI().getPath();
        if (requestPath.startsWith(USER_INFO_URI) ||
                requestPath.startsWith(ACCESS_TOKEN_URI) ||
                requestPath.startsWith(ERROR_URI) ||
                requestPath.contains(SWAGGER_URI) ||
                requestPath.contains(SWAGGER_RESOURCE) ||
                methodAnnotation != null) {
            return body;
        } else if (body instanceof Result) {
            Result result = (Result)body;
            if(!result.getSuccess()){
               response.setStatusCode(HttpStatus.BAD_REQUEST);
            }
            return body;
        } else {
            return Result.buildSuccess(body);
        }
    }
}
