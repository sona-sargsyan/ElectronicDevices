package com.company.electronicdevices;

import com.company.exceptions.UnpluggedDeviceException;

public class ElectronicDevice implements Comparable<ElectronicDevice> {
    private boolean isPowerOn;
    private int power;

    public ElectronicDevice(int power) {
        this.power = power;
        this.setIsPowerOn(false);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void switchPowerOn() {
        this.setIsPowerOn(true);
    }

    public void switchPowerOff() {
        this.setIsPowerOn(false);
    }

    public boolean isPowerOn() {
        if (this.isPowerOn == false){
            throw new UnpluggedDeviceException("Device is unplugged");
        }
        return isPowerOn;
    }

    public final void setIsPowerOn(boolean isPowerOn) {
        this.isPowerOn = isPowerOn;
    }

    @Override
    public int compareTo(ElectronicDevice device) {
        return this.getPower() - device.getPower();
    }
}
