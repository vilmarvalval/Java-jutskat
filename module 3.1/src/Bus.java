public class Bus extends Car {

    private final int passengerCapacity;
    private int passengerCount;

    public Bus(int passengerCount, String typeName) {
        super(typeName);
        super.speed = 0;
        super.gasolineLevel = 0;
        super.tankCapacity= 300;
        super.acceleration = 5;
        super.maxSpeed=150;
        super.maxCruise=100;
        super.minCruise=20;

        this.passengerCapacity=50;
        this.passengerCount = passengerCount;

        //this.typeName = typeName;   // this refers to the object itself.
    }

    public void accelerate(double amount) {
        if (super.gasolineLevel > 0) {
            //added max speed, max acceleration and acceleration amount
            double accelerate;
            accelerate =Math.min(super.acceleration, amount);
            setSpeed(getSpeed() + accelerate);
            consumeFuel(accelerate / 25);
        }
        else {
            super.speed = 0;
        }
    }

    //Using your earlier Car class create Bus class that can take a number of passengers
    // (passengerEnter() and passengerExit() or similar methods are needed probably).
    String passengerEnter(int amount){
        if (super.speed == 0){
            if (passengerCount+amount <= passengerCapacity) {
                passengerCount+=amount;
                return "Passenger count now "+passengerCount;
            } else {
                String string = "Over capacity. "+(passengerCount+amount-passengerCapacity)+" passengers left behind.";
                passengerCount = passengerCapacity;
                return string;
            }
        } else {
            return "You need to stop first!";
        }
    }

    String passengerExit(int amount){
        if (super.speed == 0){
            if (passengerCount - amount >= 0) {
                passengerCount -= amount;
                return "Passenger count: " + passengerCount;
            } else {
                passengerCount = 0;
                return "Passenger count " + passengerCount;
            }
        } else {
            return "You need to stop first!";
        }
    }
}