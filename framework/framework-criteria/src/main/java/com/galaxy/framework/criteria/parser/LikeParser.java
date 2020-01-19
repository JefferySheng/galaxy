package com.galaxy.framework.criteria.parser;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.galaxy.framework.criteria.CriteriaContext;
import com.galaxy.framework.criteria.annotation.Like;

/**
 * @author chensj
 * @date 2018-4-17
 **/
public class LikeParser extends AbstractGenericParser<Like> {

    @Override
    public Object getDefaultValue(CriteriaContext<Like> criteriaContext) {
        return criteriaContext.getType().defaultValue();
    }

    @Override
    public void doParse(CriteriaContext<Like> criteriaContext, EntityWrapper entityWrapper, String column) {
        if (criteriaContext.getType().reverse()) {
            entityWrapper.notLike(column, String.valueOf(criteriaContext.getValue()), criteriaContext.getType().likeType());
        } else {
            entityWrapper.like(column, String.valueOf(criteriaContext.getValue()), criteriaContext.getType().likeType());
        }
    }

    @Override
    public String[] getColumns(CriteriaContext<Like> criteriaContext) {
        return criteriaContext.getType().columns();
    }

    @Override
    public String getGroup(Like like) {
        return like.group();
    }

    @Override
    public boolean allowEmpty(Like like) {
        return like.allowEmpty() || StringUtils.isNotEmpty(like.defaultValue());
    }

    @Override
    public boolean isEnable(Like like) {
        return like.enable();
    }
}
