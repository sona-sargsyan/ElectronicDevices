package com.company.annotations;

import java.lang.annotation.*;

@Repeatable(ThisCodeSmell.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD,ElementType.LOCAL_VARIABLE, ElementType.MODULE, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface ThisCodeSmells {
    String reviewer() default "Petya";
    int vote();
}
