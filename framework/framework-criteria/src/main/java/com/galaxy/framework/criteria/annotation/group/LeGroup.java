package com.galaxy.framework.criteria.annotation.group;

import com.galaxy.framework.criteria.annotation.Le;

import java.lang.annotation.*;

/**
 * @author chensj
 * @date 2018-4-18
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LeGroup {

    Le[] value();
}
