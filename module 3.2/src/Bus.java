public class Bus extends Vehicle{
    private int passengerCount;
    public Bus(String name, double maxSpeed, double acceleration, double deceleration, double fuelCapacity, double fuelConsumption, int maxPassengers) {
        super(name, maxSpeed, acceleration, deceleration, fuelCapacity, fuelConsumption, maxPassengers);
    }
    public String getInfo() {
        return "Bus "+super.getBasicInfo();
    }
}