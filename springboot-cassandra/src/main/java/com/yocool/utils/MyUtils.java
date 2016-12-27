package com.yocool.utils;

import org.springframework.data.cassandra.mapping.Table;

/**
 * @author tangzq
 */
public class MyUtils {
    public static final String getTableName(Class<?> entityClass) {
        Table tableAnnon = entityClass.getAnnotation(Table.class);
        if (tableAnnon != null) {
            return tableAnnon.value();
        }
        return entityClass.getSimpleName();
    }
}
