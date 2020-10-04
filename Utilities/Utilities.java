package ParkSystem.Utilities;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.*;
import ParkSystem.Vehicle.*;

public class Utilities {
    public static List<Vehicle> vehicles = new ArrayList<Vehicle>();
    public static float profit;

    public static void AddVehicle() {
        Vehicle vehicle = new Vehicle();

        vehicle.id = Vehicle.TotalVehicleCount();

        System.out.println("-----------");
        System.out.print("Enter the vehicle plate: ");
        vehicle.plate = System.console().readLine();

        System.out.println("-----------");
        System.out.print("Enter vehicle type\nSMALL:0\nMEDIUM:1\nLARGE:2\n---->");
        String vehType = System.console().readLine();

        switch (vehType) {
            case "0":
                vehicle.type = Vehicle.VehicleType.SMALL;
                break;
            case "1":
                vehicle.type = Vehicle.VehicleType.MEDIUM;
                break;
            case "2":
                vehicle.type = Vehicle.VehicleType.LARGE;
                break;
            default:
                System.out.println("-----------");
                System.out.println("Wrong type input.");
                System.out.println("-----------");
                return;
        }

        System.out.println("-----------");
        System.out.print("Enter the owner name and surname: ");
        vehicle.owner = System.console().readLine();

        vehicle.entryTime = LocalDateTime.now();

        if (!VehicleCheck(vehicle)) {
            vehicles.add(vehicle);
            System.out.println("-----------");
            System.out.println("Vehicle is added successfully");
            System.out.println("-----------");
        } else {
            Vehicle.DecreaseVehicleCount();
            System.out.println("-----------");
            System.out.println("This vehicle is already assigned.");
            System.out.println("-----------");
            return;
        }
    }

    public static void TakeProfit() {
        System.out.println("-----------");
        System.out.println("Enter the vehicle plate.");

        String plate = System.console().readLine();

        if (FindVehicleWithPlate(plate) != null) {
            Vehicle vehicle = FindVehicleWithPlate(plate);
            LocalDateTime dateTime = LocalDateTime.now();
            switch (vehicle.type) {
                case LARGE:
                    long diff = ChronoUnit.SECONDS.between(vehicle.entryTime, dateTime);
                    profit = profit + (diff * 5);
                    break;
                case MEDIUM:
                    long diff2 = ChronoUnit.SECONDS.between(vehicle.entryTime, dateTime);
                    profit = profit + (diff2 * 4);
                    break;
                case SMALL:
                    long diff3 = ChronoUnit.SECONDS.between(vehicle.entryTime, dateTime);
                    profit = profit + (diff3 * 3);
                    break;
                default:
                    break;

            }
            System.out.println("-----------");
            System.out.println("Total profit: " + String.valueOf(profit));
            System.out.println("-----------");
            vehicles.remove(vehicle);
            return;
        }
        System.out.println("-----------");
    }

    public static void ShowAssignedVehicles() {
        System.out.println("-----------");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Owner:" + vehicle.owner + " \nPlate:" + vehicle.plate);
            System.out.println("-----------");
        }
    }

    public static void VehicleDetails() {
        System.out.println("-----------");
        System.out.println("Enter the Vehicle Plate for Details");

        String plate = System.console().readLine();
        Vehicle vehicle = FindVehicleWithPlate(plate);

        if (vehicle != null) {
            System.out.println("-----------");
            System.out.println(
                    "ID:" + vehicle.id + "\nOwner:" + vehicle.owner + "\nPlate:" + vehicle.plate
                            + "\nType:" + vehicle.type + "\nEntry Time:" + vehicle.entryTime);
        }
        System.out.println("-----------");
    }

    public static boolean VehicleCheck(Vehicle _Vehicle) {
        boolean result = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.plate.equals(_Vehicle.plate)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static Vehicle FindVehicleWithPlate(String plate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.plate.equals(plate)) {
                return vehicle;
            }
        }
        return null;
    }
}
