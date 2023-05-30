package advancedDefiningClasses.P03;

import java.util.Map;

public class Car {
    private String model;
    private double amountFuel;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, double amountFuel, double fuelCostPerKm) {
        this.model = model;
        this.amountFuel = amountFuel;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }


    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public double getAmountFuel() {
        return amountFuel;
    }

    public boolean canDrive(int kilometersToDrive) {
        double fuelNeeded = kilometersToDrive * this.fuelCostPerKm;
        if (fuelNeeded <= this.amountFuel) {
            this.amountFuel -= fuelNeeded;
            this.distanceTraveled += kilometersToDrive;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.amountFuel,this.distanceTraveled);
    }
}
