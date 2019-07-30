package com.johnlu.exercise.test.proxy;

/**
 * @author lxp
 * @date 2019/7/26 上午9:40
 * @Version 1.0
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        String n1 = "john";
        UserManagementImplProxy proxy = new UserManagementImplProxy();

        IUserManagement userProxy = (IUserManagement) proxy.bind(new UserManagementImpl());
        System.out.println(userProxy.getClass().getName());
        userProxy.addUser(n1);

    }
}
