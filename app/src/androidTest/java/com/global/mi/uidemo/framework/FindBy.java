package com.global.mi.uidemo.framework;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FindBy {

    String res() default "";
    String text() default "";
    String depth() default "";
    String position() default "0";
    String clazz() default "";
    String contentDesc() default "";
    String description() default "";

}
