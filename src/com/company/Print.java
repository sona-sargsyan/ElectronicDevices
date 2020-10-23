package com.company;

//import com.company.annotations.ThisCodeSmell;

import com.company.annotations.ThisCodeSmells;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Print {
    public static void printingClassMetadata(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();

        System.out.println("Class name is: " + clazz.getSimpleName());
        System.out.println(clazz.getSimpleName() + " has the following methods: ");
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getName());
        }

        System.out.println(clazz.getSimpleName() + " has the following fields: ");
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public static void printingAllSmeltCodeNames(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            ThisCodeSmells[] fieldAnnotations = field.getAnnotationsByType(ThisCodeSmells.class);
            System.out.println("Field Name: " + field.getName());
            for (ThisCodeSmells annotation : fieldAnnotations) {
                System.out.println("Annotation reviewer: " + annotation.reviewer());
            }

        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            ThisCodeSmells[] methodAnnotations = method.getAnnotationsByType(ThisCodeSmells.class);
            System.out.println("Method Name: " + method.getName());
            for (ThisCodeSmells annotation : methodAnnotations) {
                System.out.println("Annotation reviewer: " + annotation.reviewer());
            }
        }
    }

    public static void printingSmeltCodeAuthorityWithVote(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            ThisCodeSmells[] fieldAnnotations = field.getAnnotationsByType(ThisCodeSmells.class);
            for (ThisCodeSmells annotation : fieldAnnotations) {
                if (annotation.vote() != 0) {
                    System.out.println("Annotation reviewer: " + annotation.reviewer() + "  " + annotation.vote());
                }
            }
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            ThisCodeSmells[] methodAnnotations = method.getAnnotationsByType(ThisCodeSmells.class);
            for (ThisCodeSmells annotation : methodAnnotations) {
                if (annotation.vote() != 0) {
                    System.out.println("Annotation reviewer: " + annotation.reviewer() + "  " + annotation.vote());
                }
            }

        }

    }

    public static int getAndPrintAmountOfSmeltAnnotationsInClass(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        int annotationAmountWhichHasVote = 0;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            ThisCodeSmells[] fieldAnnotations = field.getAnnotationsByType(ThisCodeSmells.class);
            for (ThisCodeSmells annotation : fieldAnnotations) {
                if (annotation.vote() != 0) {
                    annotationAmountWhichHasVote ++;
                }

            }
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            ThisCodeSmells[] methodAnnotations = method.getAnnotationsByType(ThisCodeSmells.class);
            for (ThisCodeSmells annotation : methodAnnotations) {
                if (annotation.vote() != 0) {
                    annotationAmountWhichHasVote ++;
                }
            }

        }
        System.out.println("Smelt code votes amount is: " + annotationAmountWhichHasVote);
        return 1;
    }

}
