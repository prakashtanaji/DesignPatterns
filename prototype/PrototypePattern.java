package prototype;

public class PrototypePattern {
    public static void main(String[] args) {

        Car original = new Car();
        original.model = "Tesla";
        original.wheel = new Wheel();
        original.wheel.price = 100.0f;
        original.wheel.type = "alloy";

        System.out.println("Original object");
        printCar(original);

        // Try creating Showllow clone
        Car shallow = original.cloneShallow();
        System.out.println("Shallow object");
        printCar(shallow);

        // Modify Original Wheel price
        original.wheel.price = 200.20f;

        System.out.println("Shallow object after modifying original");
        printCar(shallow);

        // Try creating Deep clone
        Car deep = original.cloneDeep();
        System.out.println("Deep object");
        printCar(deep);

        // Modify Original Wheel price
        original.wheel.price = 300.20f;

        System.out.println("Deep object after modifying original");
        printCar(deep);
    }

    static void printCar(Car obj) {
        System.out.println("\tModel:" + obj.model);
        System.out.println("\tWheel Type:" + obj.wheel.type);
        System.out.println("\tWheel Price:" + obj.wheel.price);
    }
}

interface Vehicle {
    Vehicle cloneShallow();
    Vehicle cloneDeep();
}

class Car implements Vehicle {
    String model;
    Wheel wheel;

    @Override
    public Car cloneShallow() {
        Car clone = new Car();
        clone.model = this.model;
        // This is not proper prototype.
        // Any changes to the wheel of clone object will also change the original which was copied
        clone.wheel = this.wheel;

        return clone;
    }

    @Override
    public Car cloneDeep() {
        Car clone = new Car();
        clone.model = this.model;

        Wheel wheelClone = new Wheel();
        wheelClone.type = wheel.type;
        wheelClone.price = wheel.price;

        clone.wheel = wheelClone;
        return clone;
    }
}

class Wheel {
    String type;
    float price;
}