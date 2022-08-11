package xyz.mengnan.smallspring.test.entry;

public class User {

    private Long uid;
    private String name;

    public User(Long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Long getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                '}';
    }
}
