package com.johnlu.exercise.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lxp
 * @date 2019/7/26 上午9:51
 * @Version 1.0
 */
public class UserManagementImplProxy implements InvocationHandler {
    private Object obj;

    //    public UserManagementImplProxy(Object obj) {
    //        this.obj = obj;
    //    }
    public Object bind(Object target) {
        this.obj = target;
        return Proxy
            .newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                this);
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("proxy execute before invoke %s", method.getName()));
        Object ret = method.invoke(obj, args);
        System.out.println(String.format("proxy execute after invoke %s", method.getName()));
        return ret;
    }
}
