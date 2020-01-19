package com.galaxy.framework.criteria.parser;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.galaxy.framework.criteria.CriteriaContext;
import com.galaxy.framework.criteria.annotation.Le;

/**
 * 大于等于条件解析
 *
 * @author chensj
 * @date 2018-4-17
 **/
public class LeParser extends AbstractGenericParser<Le> {

    @Override
    public Object getDefaultValue(CriteriaContext<Le> criteriaContext) {
        return criteriaContext.getType().defaultValue();
    }

    @Override
    public void doParse(CriteriaContext<Le> criteriaContext, EntityWrapper entityWrapper, String column) {
        entityWrapper.ge(column, criteriaContext.getValue());
    }

    @Override
    public String[] getColumns(CriteriaContext<Le> criteriaContext) {
        return criteriaContext.getType().columns();
    }

    @Override
    public String getGroup(Le eq) {
        return eq.group();
    }

    @Override
    public boolean allowEmpty(Le eq) {
        return eq.allowEmpty() || StringUtils.isNotEmpty(eq.defaultValue());
    }

    @Override
    public boolean isEnable(Le eq) {
        return eq.enable();
    }
}
