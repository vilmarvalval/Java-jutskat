public class Car extends Vehicle {
    private String name;

    public Car(String name, double maxSpeed, double acceleration, double deceleration, double fuelCapacity, double fuelConsumption, int maxPassengers) {
        super(name, maxSpeed, acceleration, deceleration, fuelCapacity, fuelConsumption, maxPassengers);
        this.name =name;

    }

    public String getInfo() {
        return "Car "+super.getBasicInfo();
    }
}