package com.company.electronicdevices;

import com.company.annotations.ProdCode;

public class Microwave extends ElectronicDevice {
    private final static int power = 800;
    private boolean isKitchenEquipment = false;

    public Microwave() {
        super(power);
    }

    @ProdCode
    public void setKitchenEquipment(boolean isKitchenEquipment){
        this.isKitchenEquipment = isKitchenEquipment;
        System.out.println("+++++++++++++");
    }

    public boolean getKitchenEquipment() {
        return isKitchenEquipment;
    }
}
