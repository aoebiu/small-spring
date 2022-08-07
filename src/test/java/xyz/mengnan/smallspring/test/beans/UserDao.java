package xyz.mengnan.smallspring.test.beans;

import xyz.mengnan.smallspring.test.entry.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static final Map<String, User> hashMap = new HashMap<>();

    static {
        hashMap.put("1", new User(1L,"张三"));
        hashMap.put("2", new User(2L,"李四"));
        hashMap.put("3", new User(3L,"王五"));
        hashMap.put("4", new User(4L,"赵八"));
    }

    public Object queryUserName(String uid) {
        return hashMap.get(uid);
    }
}
