package ParkSystem.Vehicle;

import java.time.LocalDateTime;

public class Vehicle {
    private static int vehicleCounter;

    public enum VehicleType {
        SMALL, MEDIUM, LARGE
    }

    public int id;
    public VehicleType type;
    public LocalDateTime entryTime;
    public String owner;
    public String plate;

    public Vehicle() {
        vehicleCounter = vehicleCounter + 1;
    }

    public static int TotalVehicleCount() {
        return vehicleCounter;
    }
}
