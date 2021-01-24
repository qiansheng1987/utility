package com.qiansheng.fx;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>todo</p>
 *
 * @author zilong.qian@tuya.com
 * @version 1.0
 * @date 2021/1/24 10:36 上午
 */
public class LxApp {

    //private Class<T> clazz;

    private Class<?> aClass;

    public static <T> T createInstance(Class<T> aClass) throws IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        return aClass.getDeclaredConstructor().newInstance();
    }
}
