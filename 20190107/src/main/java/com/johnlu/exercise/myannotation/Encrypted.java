package com.johnlu.exercise.myannotation;

/**
 * @author lxp
 * @date 2019/7/4 上午10:32
 * @Version 1.0
 */
import java.lang.annotation.*;
import javax.crypto.*;

/**
 * 需要加解密的字段
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Encrypted {
    /**
     * 默认的加解密算法
     *
     * @return
     */

}
