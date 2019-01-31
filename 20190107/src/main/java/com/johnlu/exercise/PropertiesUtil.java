package com.johnlu.exercise;

import java.io.*;
import java.util.Map;
import java.util.Properties;


/**
 * @author John
 */
public class PropertiesUtil {

    private PropertiesUtil(){
    }

    /**
     * 读取properties文件
     *
     * @param file 文件路径
     * @return 返回properties 对象
     */
    public static Properties fromFile(String file) {
        InputStream stream = null;

        try {
            stream = new FileInputStream(new File(file));
            return fromStream(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(stream);
        }
    }

    /**
     * 读取properties文件
     *
     * @param file 文件路径
     * @return 返回properties 对象
     */
    public static Properties fromClasspath(String file) {
        InputStream stream = null;
        try {
            stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
            return fromStream(stream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(stream);
        }
    }

    /**
     * convert stream to properties
     *
     * @param stream InputStream
     * @return Properties
     */
    private static Properties fromStream(InputStream stream) throws IOException {
        Properties dest = new Properties();
        Properties src = new Properties();
        BufferedReader bf = new BufferedReader(new InputStreamReader(stream));
        src.load(bf);

        // 如果key value为字符串，需要trim一下
        for (Map.Entry<Object, Object> entry : src.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();

            Object newKey = key;
            Object newValue = value;
            if (newKey instanceof String) {
                newKey = key.toString().trim();
            }

            if (newValue instanceof String) {
                newValue = value.toString().trim();
            }

            dest.put(newKey, newValue);
        }

        return dest;
    }

    /**
     * dispose stream
     *
     * @param stream InputStream
     */
    private static void close(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
            }
        }
    }
}
