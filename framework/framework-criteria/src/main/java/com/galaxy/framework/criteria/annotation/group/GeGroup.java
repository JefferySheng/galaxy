package com.galaxy.framework.criteria.annotation.group;

import com.galaxy.framework.criteria.annotation.Ge;

import java.lang.annotation.*;

/**
 * @author chensj
 * @date 2018-4-18
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GeGroup {

    Ge[] value();
}
