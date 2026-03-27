/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */

public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private final double acceleration; //added acceleration
    private final double maxSpeed;

    private boolean cruiseOn = false;
    private double cruiseSpeed;
    private final double maxCruise;
    private final double minCruise;
    
    private final double tankCapacity; //added tank capacity
    private double gasolineLevel;
    
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
        if (gasolineLevel > 0) {
            //added max speed, max acceleration and acceleration amount
            speed = Math.min(maxSpeed, speed+Math.min(acceleration, amount));
            gasolineLevel -= 1; //added car consuming gas
        }
        else
            speed = 0;
    }
    void decelerate(double amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    double getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        while (gasolineLevel < tankCapacity){
            gasolineLevel += 1; //added a slightly more realistic filling
        }
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }

    String cruiseOnOff(){
        this.cruiseOn = !this.cruiseOn;
        return cruise();
    }

    String cruise(){
        if (this.cruiseOn){
            if (this.cruiseSpeed < this.minCruise || this.cruiseSpeed > this.maxCruise){
                this.cruiseOnOff();
                return "Outside of allowed cruise boundaries(20-180), cruise control has been turned off.";
            } else {
                while (this.speed < this.cruiseSpeed) {
                    if (this.getGasolineLevel() <=0) {
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