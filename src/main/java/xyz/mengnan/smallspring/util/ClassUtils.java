package xyz.mengnan.smallspring.util;

public class ClassUtils {

    private ClassUtils() {}

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // 异常直接捕捉后返回本类的类加载器
        }
        if (cl == null) {
            // 直接返回本类的类加载器
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

}
