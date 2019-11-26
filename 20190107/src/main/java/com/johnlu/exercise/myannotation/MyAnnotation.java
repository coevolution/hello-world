package com.johnlu.exercise.myannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author lxp
 * @date 2019/7/4 上午9:59
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME) public @interface MyAnnotation {
    String name() default ("默认");

    int val() default (1000);
}
