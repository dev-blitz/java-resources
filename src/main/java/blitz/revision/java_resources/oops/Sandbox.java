package blitz.revision.java_resources.oops;

import blitz.revision.java_resources.oops.abstraction.Car;
import blitz.revision.java_resources.oops.abstraction.Vehicle;
import blitz.revision.java_resources.oops.abstraction.VehicleType;

public class Sandbox {
    public static void main(String[] args) {
        Vehicle obj = new Car("model-x", VehicleType.CAR, 2010, "tesla-model-x", 1998);
        obj.drive();
    }
}
