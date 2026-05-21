//Create a Java interface named Vehicle with the following methods:
//
//start(): This method should print a message indicating that the vehicle is starting.
//stop(): This method should print a message indicating that the vehicle is stopping.
//getInfo(): This method should return a string containing information about the vehicle.

public class Vehicle {
    private boolean on = false;
    private boolean hasDriver= false;
    private final String name;
    private final int maxPassengers;
    private int currentPassengers;
    //implement passanger count on all vehicles

    private final double fuelConsumption;
    private final double fuelCapacity;
    private double fuelCurrent;

    private double speed;
    private final double acceleration;
    private final double deceleration;
    private final double maxSpeed;
    private double odometer;

    public Vehicle(String name, double maxSpeed, double acceleration, double deceleration, double fuelCapacity, double fuelConsumption, int maxPassengers) {
        this.name = name;
        this.odometer = 0;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.fuelCapacity = fuelCapacity;
        this.fuelCurrent = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.maxPassengers = maxPassengers;
        this.currentPassengers = 0;
    }

    public String getBasicInfo() {
        return "'"+this.name+"'\n" +
                "Has driver: "+this.hasDriver+"\n" +
                "Fuel: " +this.fuelCurrent+"/"+this.fuelCapacity+"l. Speed: "+this.speed+"/"+this.maxSpeed+"kmh.\n" +
                "Running: "+this.on+". Odometer: "+this.odometer +"km.\n" +
                "Max consumption: "+this.fuelConsumption+"l/t.\n" +
                "Max acceleration: "+this.acceleration+"kmh/t. Breaking power: "+this.deceleration+"kmh/t. \n"+
                "Passenger count: "+this.currentPassengers+"/"+this.maxPassengers+" people.\n";
    }

    protected String start() {
        if (this.hasDriver) {
            setFuel(this.fuelCurrent-fuelConsumption/100);
            this.on = true;
            return "Vehicle '"+this.name+"' started.";
        } else {
            return "Vehicle '"+this.name+"' needs a driver to start.";
        }
    }
    protected String stop() {
        if (this.hasDriver){
            this.on = false;
            return "Vehicle '"+this.name+"' stopped.";
        } else {
            return "Vehicle '"+this.name+"' needs a driver to stop.";
        }
    }

    private void setSpeed(double speed) {
        this.speed = Math.max(Math.min(this.maxSpeed, speed), 0);
    }
    private void setFuel(double amount) {
        this.fuelCurrent = Math.max(Math.min(this.fuelCapacity,amount), 0);
    }

    protected void refuel(double amount) {
        setFuel(this.fuelCurrent + amount);
    }

    protected double accelerate(double acceleration) {
        double accelerate = Math.min(acceleration, this.acceleration);
        //consumes fuel based on acceleration, max consumption at max acceleration
        setFuel(this.fuelCurrent-fuelConsumption*(accelerate/this.acceleration));
        setSpeed(accelerate + this.speed);
        return accelerate;
    }
    protected double decelerate(double deceleration) {
        double decelerate = Math.min(deceleration, this.deceleration);
        setSpeed(this.speed-decelerate);
        return decelerate;
    }

    protected double travel(double time){
        //consumes fuel based on speed and time, max consumption rate at max speed
        setFuel(this.fuelCurrent-(fuelConsumption*(this.speed/this.maxSpeed))*time);
        double distance = this.speed * time;
        odometer += distance;
        return distance;
    }

    protected void enter(){
        this.hasDriver = true;
    }
    protected void exit(){
        this.hasDriver = false;
    }

    private String setPassenger(int amount){
        if (this.currentPassengers+amount > this.maxPassengers) {
            int overflow = this.currentPassengers+amount - this.maxPassengers;
            this.currentPassengers = Math.max(Math.min(this.currentPassengers+amount, this.maxPassengers),0);
            return "Exceeded maximum number of passengers," +
                    "\n dismissed overflow of: "+overflow+" passenger(s)."+
                    "\nCurrent passengers in '"+this.name+"': "+this.currentPassengers+"/"+this.maxPassengers;
        }
        if (this.currentPassengers+amount < 0) {
            int underflow = this.currentPassengers+amount;
            this.currentPassengers = Math.max(Math.min(this.currentPassengers+amount, this.maxPassengers),0);
            return "Passenger count cannot be negative," +
                    "\n dismissed underflow of: "+-underflow+" passenger(s)."+
                    "\nCurrent passengers in '"+this.name+"': "+this.currentPassengers+"/"+this.maxPassengers;
        }
        this.currentPassengers = Math.max(Math.min(this.currentPassengers+amount, this.maxPassengers),0);
        return  "Current passengers in '"+this.name+"': "+this.currentPassengers+"/"+this.maxPassengers;
    }

    protected String passengerEnter(int amount){
        return setPassenger(amount);
    }
    protected String passengerExit(int amount){
        return setPassenger(-amount);
    }
}