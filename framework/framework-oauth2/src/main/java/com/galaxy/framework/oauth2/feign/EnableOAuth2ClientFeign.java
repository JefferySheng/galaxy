package com.galaxy.framework.oauth2.feign;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author aaron.pan
 * @date 2018/5/24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OAuth2ClientFeignConfiguration.class)
public @interface EnableOAuth2ClientFeign {
}
