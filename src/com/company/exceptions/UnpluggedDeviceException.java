package com.company.exceptions;

public final class UnpluggedDeviceException extends DeviceException {
    public UnpluggedDeviceException(String errorMessage){
        super(errorMessage);
    }
}
