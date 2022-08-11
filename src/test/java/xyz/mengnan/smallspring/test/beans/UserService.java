package xyz.mengnan.smallspring.test.beans;

import xyz.mengnan.smallspring.test.entry.User;

public class UserService {

    private String name;
    private String uid;
    private UserDao userDao;

    public UserService() {
    }

    public UserService(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public UserService(String name, String uid, UserDao userDao) {
        this.name = name;
        this.uid = uid;
        this.userDao = userDao;
    }

    public UserService(String name) {
        this.name = name;
    }

    public String queryUserInfo() {
        if (userDao != null) {
            User user = userDao.queryUserName(uid);
            System.out.println("查询到此用户的详细信息" + user);

            this.name = user.getName();
        }
        return name;
    }

}
