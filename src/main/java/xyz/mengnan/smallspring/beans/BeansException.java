package xyz.mengnan.smallspring.beans;

/**
 * bean异常,bean装载时候相关的异常类
 * 继承RuntimeException,出现异常时不必捕捉
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
