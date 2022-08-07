package xyz.mengnan.smallspring.test.beans;

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
        System.out.println(uid);
        if (userDao != null) {
            System.out.println("查询到此用户的详细信息" + userDao.queryUserName(uid));
        }
        return name;
    }

}
