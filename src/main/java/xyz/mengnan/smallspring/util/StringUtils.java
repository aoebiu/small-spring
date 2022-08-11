package xyz.mengnan.smallspring.util;

public class StringUtils {

    public StringUtils() {}

    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static String lowerFirst(CharSequence str) {
        if (str == null)
            return null;
        char firstChar = str.charAt(0);
        if (Character.isUpperCase(firstChar)) {
            return Character.toLowerCase(firstChar) + str.subSequence(1, str.length()).toString();
        }
        return str.toString();
    }
}
