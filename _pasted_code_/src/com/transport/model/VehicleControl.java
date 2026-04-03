package com.transport.model;

public interface VehicleControl {
    void start();
    void stop();
    void changeGear(int gear);
}