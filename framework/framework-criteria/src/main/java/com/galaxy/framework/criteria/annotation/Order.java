package com.galaxy.framework.criteria.annotation;

import java.lang.annotation.*;

/**
 * 用于指定条件的顺序
 * @author chensj
 * @date 2018-4-19
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Order {
    int value() default 0;
}
