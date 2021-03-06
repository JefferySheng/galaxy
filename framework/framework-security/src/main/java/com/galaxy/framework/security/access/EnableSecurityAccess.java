package com.galaxy.framework.security.access;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author aaron.pan
 * @date 2018/5/24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SecurityAccessAutoConfiguration.class)
public @interface EnableSecurityAccess {
}
