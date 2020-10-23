package com.company;

import com.company.annotations.ProdCode;
import com.company.electronicdevices.Microwave;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProdRunner {

    public static void onlyProdMethods() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("com.company.electronicdevices.Microwave");
        Constructor microwaveConstructor = clazz.getConstructor();
        Microwave microwave = (Microwave) microwaveConstructor.newInstance();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getAnnotationsByType(ProdCode.class).length != 0) {
                method.invoke(microwave, true);
            }
        }

    }
}
