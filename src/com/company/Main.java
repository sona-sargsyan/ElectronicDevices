package com.company;

//import com.company.annotations.ThisCodeSmell;
import com.company.electronicdevices.*;
import com.company.exceptions.DeviceException;
import com.company.exceptions.UndefinedDeviceException;
import com.company.exceptions.UnpluggedDeviceException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.company.Print.getAndPrintAmountOfSmeltAnnotationsInClass;
import static com.company.Print.printingSmeltCodeAuthorityWithVote;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        ElectronicDevice refrigerator = new Refrigerator();
        ElectronicDevice tv = new TV();
        ElectronicDevice vacuum = new Vacuum();

        tv.setIsPowerOn(true);
        refrigerator.setIsPowerOn(true);
        Room room = new Room();

        Room.addDeviceToRoom(tv);
        Room.addDeviceToRoom(vacuum);
        Room.addDeviceToRoom(tv);
        Room.addDeviceToRoom(refrigerator);

        // (5 points) Use reflection to instantiate all objects in client code via constructors (with or without arguments)
        Class<?> microwaveClass = Class.forName("com.company.electronicdevices.Microwave");
        Constructor microwaveConstructor = microwaveClass.getConstructor();
        Microwave microwave = (Microwave) microwaveConstructor.newInstance();

        // (5 points) Use reflection API to fill private fields without setters
        Field field = microwaveClass.getDeclaredField("isKitchenEquipment");
        field.setAccessible(true);
        field.set(microwave, true);
        System.out.println(microwave.getKitchenEquipment());

        // (5 points) Use reflection API to change method calls from direct call on reflection call in client code
        Method setKitchenEquipmentMethod = microwaveClass.getMethod("setKitchenEquipment", boolean.class);
        setKitchenEquipmentMethod.invoke(microwave, false);
        System.out.println(microwave.getKitchenEquipment());

        // (5 points) Print out the metadata for all classes in application in human-readable format format (about all fields, methods, modifiers and etc.)
        System.out.println("-------------");
        Print.printingClassMetadata("com.company.electronicdevices.Microwave");
        System.out.println("-------------");
        Print.printingClassMetadata("com.company.electronicdevices.ElectronicDevice");

        // Print out all smelt code names (classes, method, fields)
        System.out.println("-------------");
        Print.printingAllSmeltCodeNames("com.company.electronicdevices.Room");

        // Print out authority of persons who count this code smelt and vote for it
        System.out.println("-------------");
        printingSmeltCodeAuthorityWithVote("com.company.electronicdevices.Room");

        // Print out range all smelt code areas by votes (amount of annotations)
        System.out.println("-------------");
        getAndPrintAmountOfSmeltAnnotationsInClass("com.company.electronicdevices.Room");

        ProdRunner.onlyProdMethods();

        try {

            room.findDevices(device -> device.getPower() >= 700);
            room.sortDevices(ElectronicDevice::getPower);

            room.findDevices(device -> device.getPower() < 900);
            room.sortDevices(ElectronicDevice::isPowerOn);

            room.findDevices(device -> device.getPower() > 600);
            room.sortDevices(ElectronicDevice::getPower);

            room.findDevices(device -> device.getPower() == 500);
            room.sortDevices(ElectronicDevice::isPowerOn);


        } catch (UndefinedDeviceException | UnpluggedDeviceException ex) {
            ex.printStackTrace();
        } catch (DeviceException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Program has some defined exceptions!");
        }



    }
}
