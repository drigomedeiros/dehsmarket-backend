package com.dehsmarket.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class Converter {

    private Converter(){}

    public static <T> T convertTo(Class<T> clazz, Object from) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

        T to = clazz.getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(to, from);
        return to;

    }

    public static <T> List<T> convertToListOf(Class<T> clazz, List<Object> from) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

        var listOf = new ArrayList<T>();

        for(var object : from){

            listOf.add(convertTo(clazz, object));

        }
        
        return listOf;

    }
    
}
