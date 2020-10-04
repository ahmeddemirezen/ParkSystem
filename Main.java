package ParkSystem;

import ParkSystem.Utilities.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the park system.");

        while (true) {
            try {
                // todo show vehicles and vehicles details will be added.
                System.out.print(
                        "Choose the process.\n1)Add Vehicle\n2)Take Bill From Plate\n3)Show Vehicles\n4)Show Vehicle Details\n5)Exit");

                // Todo it is crashed when input coming null. 1/2
                int chosenStatement = Integer.parseInt(System.console().readLine());

                switch (chosenStatement) {
                    case 1:
                        Utilities.AddVehicle();
                        break;
                    case 2:
                        Utilities.TakeProfit();
                        break;
                    case 3:
                        Utilities.ShowAssignedVehicles();
                        break;
                    case 4:
                        Utilities.VehicleDetails();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("\n\nEntered input is out of the range.\n");
                        break;
                }
            } catch (Exception exception) {
            }
        }
    }
}
