package xyz.mengnan.smallspring.util;

import java.util.function.Supplier;

public class Assert {

    private Assert() {}

    public static <T> T notNull(T object, String errorMsgTemplate) throws IllegalArgumentException {
        return notNull(object, () -> new IllegalArgumentException(errorMsgTemplate));
    }

    public static <T, X extends Throwable> T notNull(T object, Supplier<X> errorSupplier) throws X {
        if (null == object) {
            throw errorSupplier.get();
        }
        return object;
    }

}
