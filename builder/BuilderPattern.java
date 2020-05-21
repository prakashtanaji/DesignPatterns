package builder;

public class BuilderPattern {

    public static void main(String[] args) {
        TeslaBuilder builder = Tesla.builder();

        builder.setModel("X");
        builder.setColor("Red");
        builder.setWheels("Alloy");
        builder.setSeats("5");

        Tesla obj = builder.build();

        System.out.println("Model: " + obj.model);
        System.out.println("Color: " + obj.color);
        System.out.println("Wheels: " + obj.wheels);
        System.out.println("Seats: " + obj.seats);
    }
}

// This is main object the client wants to create instance
class Tesla {

    // Some of the properties if the object. 
    String model;
    String color;
    String wheels;
    String seats;

    // There could be way more properties, which will make constructor inputs size pretty big for client to pass in in single line
    public Tesla(String model, String color, String wheels, String seats) {
        this.model = model;
        this.color = color;
        this.wheels = wheels;
        this.seats = seats;
    }

    // The Main class will provides clients a helper to build the object piece by piece
    public static TeslaBuilder builder() {
        return new TeslaBuilder();
    }
}

// Helper class provides setter methods one for each of the main objects properties
// this will help in building the object piece by piece, which is really helpful if the object has lot of constructor parameters
class TeslaBuilder {
    String _model;
    String _color;
    String _wheels;
    String _seats;

    public TeslaBuilder() {
    }

    public void setModel(String model) {
        _model = model;
    }

    public void setColor(String color) {
        _color = color;
    }

    public void setWheels(String wheels) {
        _wheels = wheels;
    }

    public void setSeats(String seats) {
        _seats = seats;
    }

    // When all the required properties are set, the object will be created and returned to client
    public Tesla build() {
        return new Tesla(_model, _color, _wheels, _seats);
    }
}