package com.galaxy.framework.util;

import org.apache.commons.lang3.*;

import java.util.Objects;

/**
 * @author aaron.pan
 * @date 2018/5/24
 */
public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils{

    public static boolean isNull(Object value){
        if(value instanceof String){
            return org.apache.commons.lang3.StringUtils.isEmpty((String)value);
        }
        return Objects.isNull(value);
    }
}