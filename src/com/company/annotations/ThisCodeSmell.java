package com.company.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD,ElementType.LOCAL_VARIABLE, ElementType.MODULE, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThisCodeSmell {
    ThisCodeSmells[] value();
}