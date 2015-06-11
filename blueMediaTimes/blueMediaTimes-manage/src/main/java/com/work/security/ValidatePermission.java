package com.work.security;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: Haffner
 * Date: 12-11-16
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class ValidatePermission {
    public static Permission parsePermission(Class<?> clazz, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        // 根据方法名，取得方法，如果有则返回
        Method method = clazz.getMethod(methodName, parameterTypes);
        if (method != null && method.isAnnotationPresent(Permission.class)) {
            Permission permission = method.getAnnotation(Permission.class);
            if (null != permission)
                return permission;
        }
        return null;
    }

    public static Permission parsePermission(Method method) throws NoSuchMethodException {
        // 根据方法名，取得方法，如果有则返回
        if (method != null && method.isAnnotationPresent(Permission.class)) {
            Permission permission = method.getAnnotation(Permission.class);
            if (null != permission)
                return permission;
        }
        return null;
    }
}
