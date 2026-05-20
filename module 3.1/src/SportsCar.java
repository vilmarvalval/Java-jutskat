//Using your earlier Car class create SportsCar class that has better acceleration and deceleration
// (and higher gasoline consumption) than an ordinary Car.

/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on super later).
 */

public class SportsCar extends Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */

    /* super is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public SportsCar(String typeName) {
        super(typeName);
        super.speed = 0;
        super.gasolineLevel = 0;
        super.tankCapacity= 100;
        super.acceleration = 20;
        super.maxSpeed=200;
        super.maxCruise=180;
        super.minCruise=20;
        //this.typeName = typeName;   // super refers to the object itself.

        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
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
}