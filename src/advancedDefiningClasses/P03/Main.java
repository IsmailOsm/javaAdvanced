package advancedDefiningClasses.P03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> map = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            double amountFuel = Double.parseDouble(carInfo[1]);
            double fuelCostPerKm = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, amountFuel, fuelCostPerKm);
            map.put(model, car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String carModelToDrive = command.split("\\s+")[1];
            int kilometersToDrive = Integer.parseInt(command.split("\\s+")[2]);
            Car carToDrive = map.get(carModelToDrive);
            if (carToDrive.canDrive(kilometersToDrive)) {

            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }
        for (Car car : map.values()) {
            System.out.println(car);
        }
    }
}
