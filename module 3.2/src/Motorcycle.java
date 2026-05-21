public class Motorcycle extends Vehicle {
    public Motorcycle(String name, double maxSpeed, double acceleration, double deceleration, double fuelCapacity, double fuelConsumption, int maxPassengers) {
        super(name, maxSpeed, acceleration, deceleration, fuelCapacity, fuelConsumption,  maxPassengers);
    }

    public String getInfo() {
        return "Motorcycle "+super.getBasicInfo();
    }
}