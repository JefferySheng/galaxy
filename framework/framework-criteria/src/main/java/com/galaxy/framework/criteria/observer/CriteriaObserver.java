package com.galaxy.framework.criteria.observer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.galaxy.framework.criteria.CriteriaContext;

/**
 * @author chensj
 * @date 2018-4-18
 **/
public class CriteriaObserver<T> implements Observer<T>{

    @Override
    public void beforeParse(EntityWrapper<T> wrapper) {

    }

    @Override
    public void afterParse(EntityWrapper<T> wrapper) {

    }

    @Override
    public boolean onParse(CriteriaContext<?> criteriaContext, EntityWrapper<T> wrapper) {
        return false;
    }
}
