/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */

public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    protected double speed;
    protected double acceleration; //added acceleration
    protected double maxSpeed;

    private boolean cruiseOn = false;
    private double cruiseSpeed;
    protected double maxCruise;
    protected double minCruise;

    protected double tankCapacity; //added tank capacity
    protected double gasolineLevel;
    
    private final String typeName;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName) {
        speed = 0; gasolineLevel = 0; tankCapacity= 100; acceleration = 10; maxSpeed=200; maxCruise=180; minCruise=20;
        this.typeName = typeName;   // this refers to the object itself.
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate(double amount) {
        if (this.gasolineLevel > 0) {
            //added max speed, max acceleration and acceleration amount
            this.speed = Math.min(this.maxSpeed, this.speed+Math.min(this.acceleration, amount));
            this.gasolineLevel = Math.max(0, this.gasolineLevel-1); //added car consuming gas
        }
        else {
            this.speed = 0;
        }
    }
    void decelerate(double amount) {
        if (this.gasolineLevel > 0) {
            if (amount > 0)
                this.speed = Math.max(0, this.speed - amount);
        } else
            this.speed = 0;
    }
    public double getSpeed() {
        return speed;
    }
    protected void setSpeed(double speed) {
        this.speed = Math.max(0, Math.min(speed, maxSpeed));
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }
    protected void consumeFuel(double amount) {
        gasolineLevel = Math.max(0, gasolineLevel - amount); //clamped consumption + safer modification of values
    }

    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        System.out.println("Filling tank of "+typeName);
        while (gasolineLevel < tankCapacity){
            gasolineLevel += 1; //added a slightly more realistic filling
        }
    }

    String cruiseOnOff(){
        this.cruiseOn = !this.cruiseOn;
        return cruise();
    }

    boolean isCruiseOn(){
        return this.cruiseOn;
    }

    String cruise(){
        if (this.cruiseOn){
            if (this.cruiseSpeed < this.minCruise || this.cruiseSpeed > this.maxCruise){
                this.cruiseOnOff();
                return "Outside of allowed cruise boundaries(20-180), cruise control has been turned off.";
            } else {
                while (this.speed < this.cruiseSpeed) {
                    if (getGasolineLevel() <=0) {
                        this.cruiseOnOff();
                        return "The car is out of gas, cruise control has been turned off.";
                    }
                    this.accelerate(this.cruiseSpeed - this.speed);
                }
                while (this.speed > this.cruiseSpeed) {
                    this.decelerate(this.speed - this.cruiseSpeed);
                }
                return "Set cruise speed of " + this.cruiseSpeed + " km/h achieved.";
            }
        } else {
            return "Cruise is off.";
        }
    }

    String setCruise(int set){
        this.cruiseSpeed = set;
        return cruise();
    }
    double getCurrentCruise(){
        return this.cruiseSpeed;
    }
}