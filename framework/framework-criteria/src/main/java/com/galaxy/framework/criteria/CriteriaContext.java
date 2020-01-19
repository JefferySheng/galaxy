package com.galaxy.framework.criteria;

import java.lang.annotation.Annotation;

/**
 * @author aaron.pan
 * @date 2018/5/24
 */
public class CriteriaContext<S extends Annotation> {

    /**
     * 条件类型
     */
    private S type;

    /**
     * 字段的值
     */
    private Object value;

    /**
     * 字段名称
     */
    private String property;

    /**
     * 查询对象
     */
    private Criteria criteria;

    /**
     * 字段数据类型
     */
    private Class<?> dataType;

    public S getType() {
        return type;
    }

    public void setType(S type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Class<?> getDataType() {
        return dataType;
    }

    public void setDataType(Class<?> dataType) {
        this.dataType = dataType;
    }

    public CriteriaContext(S type, Object value, String property, Criteria criteria, Class<?> dataType) {
        this.type = type;
        this.value = value;
        this.property = property;
        this.criteria = criteria;
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "CriteriaContext{" +
                "type=" + type +
                ", value=" + value +
                ", property='" + property + '\'' +
                ", criteria=" + criteria +
                ", dataType=" + dataType +
                '}';
    }
}

