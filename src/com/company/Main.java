package com.company;

import com.company.electronicdevices.*;
import com.company.exceptions.DeviceException;
import com.company.exceptions.UndefinedDeviceException;
import com.company.exceptions.UnpluggedDeviceException;

public class Main {

    public static void main(String[] args) {

        ElectronicDevice microwave = new Microwave();
        ElectronicDevice refrigerator = new Refrigerator();
        ElectronicDevice tv = new TV();
        ElectronicDevice vacuum = new Vacuum();

        tv.setIsPowerOn(true);
        refrigerator.setIsPowerOn(true);
        Room room = new Room();

        Room.addDeviceToRoom(tv);
        Room.addDeviceToRoom(microwave);
        Room.addDeviceToRoom(vacuum);
        Room.addDeviceToRoom(tv);
        Room.addDeviceToRoom(refrigerator);

        try {

            room.findDevices(device -> device.getPower() > 700);
            room.sortDevices(device -> device.getPower());

            room.findDevices(device -> device.getPower() > 900);
            room.sortDevices(device -> device.isPowerOn());

            room.findDevices(device -> device.getPower()<600);
            room.sortDevices(device -> device.getPower());

            room.findDevices(device -> device.getPower()==500);
            room.sortDevices(device -> device.isPowerOn());


        } catch (UndefinedDeviceException ex) {
            ex.printStackTrace();
        } catch (UnpluggedDeviceException ex) {
            ex.printStackTrace();
        } catch (DeviceException ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("Program has some defined exceptions!");
        }

    }
}
