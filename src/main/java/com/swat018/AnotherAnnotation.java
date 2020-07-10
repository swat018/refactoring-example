package com.swat018;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnotherAnnotation {

    String value() default "jinwoo";

    int number() default  100;

}
