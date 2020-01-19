package com.galaxy.framework.criteria.annotation.group;

import com.galaxy.framework.criteria.annotation.OrderBy;

import java.lang.annotation.*;

/**
 * @author chensj
 * @date 2018-4-18
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OrderByGroup {

    OrderBy[] value();
}
