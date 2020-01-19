package com.galaxy.framework.criteria.factory;

import com.baomidou.mybatisplus.toolkit.ReflectionKit;
import com.galaxy.framework.criteria.parser.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chensj
 * @date 2018-4-19
 **/
public class CriteriaParserFactory {

    private static Map<Class<?>, ConditionParser<?>> repository = new ConcurrentHashMap<>();

    static {
        register(new BetweenAndParser());
        register(new LikeParser());
        register(new LtParser());
        register(new LeParser());
        register(new GeParser());
        register(new GtParser());
        register(new EqParser());
        register(new InParser());
    }

    /**
     * 获取解析器
     * @param clazz
     * @return
     */
    public static ConditionParser<?> getParser(Class<?> clazz) {
        return repository.get(clazz);
    }

    /**
     * 注册解析器
     * @param conditionParser
     */
    public static void register(ConditionParser conditionParser) {
        Class<?> type = ReflectionKit.getSuperClassGenricType(conditionParser.getClass(), 0);
        repository.put(type, conditionParser);
    }

}
