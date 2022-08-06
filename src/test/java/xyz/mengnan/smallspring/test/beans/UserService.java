package xyz.mengnan.smallspring.test.beans;

public class UserService {

    private String name;

    public UserService() {}

    public UserService(String name) {
        this.name = name;
    }

    public String queryUserInfo() {
        return name;
    }

}
