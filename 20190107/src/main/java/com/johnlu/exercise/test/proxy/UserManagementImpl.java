package com.johnlu.exercise.test.proxy;

/**
 * @author lxp
 * @date 2019/7/26 上午9:49
 * @Version 1.0
 */
public class UserManagementImpl implements IUserManagement {
    @Override public int addUser(String name) {
        System.out.println(String.format("add user %s",name));
        return 2;
    }
    public int delUser(String name) {
        System.out.println(String.format("delete user %s",name));
        return 1;
    }
}
