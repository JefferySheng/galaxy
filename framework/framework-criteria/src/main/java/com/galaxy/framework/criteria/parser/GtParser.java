package com.galaxy.framework.criteria.parser;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.galaxy.framework.criteria.CriteriaContext;
import com.galaxy.framework.criteria.annotation.Gt;

/**
 * 大于等于条件解析
 *
 * @author chensj
 * @date 2018-4-17
 **/
public class GtParser extends AbstractGenericParser<Gt> {

    @Override
    public Object getDefaultValue(CriteriaContext<Gt> criteriaContext) {
        return criteriaContext.getType().defaultValue();
    }

    @Override
    public void doParse(CriteriaContext<Gt> criteriaContext, EntityWrapper entityWrapper, String column) {
        entityWrapper.gt(column, criteriaContext.getValue());
    }

    @Override
    public String[] getColumns(CriteriaContext<Gt> criteriaContext) {
        return criteriaContext.getType().columns();
    }

    @Override
    public String getGroup(Gt gt) {
        return gt.group();
    }

    @Override
    public boolean allowEmpty(Gt gt) {
        return gt.allowEmpty() || StringUtils.isNotEmpty(gt.defaultValue());
    }

    @Override
    public boolean isEnable(Gt gt) {
        return gt.enable();
    }
}
