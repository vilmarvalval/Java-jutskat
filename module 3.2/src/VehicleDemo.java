//2.
//Create three classes: Car, Motorcycle, and Bus, each is implementing the Vehicle interface.

//3.
//Implement the start(), stop(), and getInfo() methods in each class
// with appropriate messages and vehicle information.

//4.
//Create a Java class named VehicleDemo with a main method to demonstrate the interface implementations.
// In the main method, perform the following actions:
//Create instances of Car, Motorcycle, and Bus.
//Start and stop each vehicle.
//Display information about each vehicle.

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car(
                "Car1", 200,10,20,100,5,4
                    );
        Motorcycle bike = new Motorcycle(
                "Bike1", 250,5,10,30,2,1
                    );
        Bus bus = new Bus(
                    "Bus1",100,5,10,150,10, 120
                    );
        System.out.println(car.getInfo());
        System.out.println(bike.getInfo());
        System.out.println(bus.getInfo());

        System.out.println(car.start());
        car.enter();
        System.out.println(car.start());

        bike.enter();
        bus.enter();
        System.out.println(bike.start());
        System.out.println(bus.start());

        bike.exit();
        bus.stop();
        bus.exit();
        System.out.println(car.getInfo());
        System.out.println(bike.getInfo());
        System.out.println(bus.getInfo());

        System.out.println(bike.stop());
        bike.enter();
        bike.stop();
        car.stop();
        car.exit();
        bike.exit();

        System.out.println(bike.passengerEnter(2));
        System.out.println(car.passengerEnter(3));
        System.out.println(bus.passengerEnter(42));

        System.out.println(car.getInfo());
        System.out.println(bike.getInfo());
        System.out.println(bus.getInfo());

        System.out.println(bike.passengerExit(2));
    }
}