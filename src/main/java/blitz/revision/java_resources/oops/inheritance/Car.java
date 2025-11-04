package blitz.revision.java_resources.oops.inheritance;

import blitz.revision.java_resources.oops.inheritance.Vehicle;

public class Car implements Vehicle {
    private String type = this.getClass().getSuperclass().getName();
    private String model;
    private int horsePower;

    public Car(String model, int horsePower) {
        this.model = model;
        this.horsePower = horsePower;
    }

    @Override
    public void drive() {
       System.out.println("Driving...");
    }

    @Override
    public void park() {
        System.out.println("parked...");
    }

    @Override
    public String getDetails() {
        return "details: [\n\ttype: " + this.type + "\n\tmodel: " + this.model +
            "\n\thorse-power: " + this.horsePower + "\n]";
    }
}
