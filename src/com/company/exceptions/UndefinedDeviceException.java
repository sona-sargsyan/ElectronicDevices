package com.company.exceptions;

public final class UndefinedDeviceException extends DeviceException {
    public UndefinedDeviceException(String errorMessage){
        super(errorMessage);
    }
}
