package com.company.electronicdevices;

import com.company.annotations.ThisCodeSmells;
import com.company.exceptions.UndefinedDeviceException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Room {

    @ThisCodeSmells(reviewer = "Naira", vote = 6)
    @ThisCodeSmells(reviewer = "Pogos", vote = 2)
    public static List<ElectronicDevice> roomDevices;

    public Room() {
        this.roomDevices = new ArrayList<>();
    }


    public List<ElectronicDevice> getRoomDevices() {
        return roomDevices;
    }

    @ThisCodeSmells(reviewer = "Naira", vote = 5)
    public List<ElectronicDevice> findDevices(Predicate<ElectronicDevice> filter) {

        List<ElectronicDevice> foundDevices = (List<ElectronicDevice>) roomDevices.stream().filter(filter).collect(Collectors.toList());
        if (foundDevices.isEmpty()) {
            throw new UndefinedDeviceException("There is no this kind of device!");
        }
        return foundDevices;
    }

    @SuppressWarnings("unchecked")
    public List<ElectronicDevice> sortDevices(Function<ElectronicDevice, Comparable> sort) {

        List<ElectronicDevice> sortedDevices =(List<ElectronicDevice>) roomDevices.stream().sorted(Comparator.comparing(sort)).collect(Collectors.toList());
        if (sortedDevices.isEmpty()) {
            throw new IllegalArgumentException("Devices are not sortable!");
        }
        return sortedDevices;
    }

    @Deprecated
    public static void addDeviceToRoom(ElectronicDevice device) {
        roomDevices.add(device);
    }
}
