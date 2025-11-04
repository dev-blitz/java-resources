package blitz.revision.java_resources.oops.abstraction;

import blitz.revision.java_resources.oops.abstraction.VehicleType;
import java.time.LocalDate;

public abstract class Vehicle {
  private String name;
  private VehicleType type;

  public Vehicle(String name, VehicleType type) {
    this.name = name;
    this.type = type;
  }

  public abstract void drive();

  public VehicleType  getType() {
    return type;
  }
}

