package xyz.mengnan.smallspring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 实现Resource,获取读取系统资源
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
