package blitz.revision.java_resources.oops.abstraction;

public enum VehicleType {
  CAR("car"),
  BYCYCLE(""),
  MOTORCYCLE(""),
  TRUCK(""),
  BUS("");

  private final String type;

  private VehicleType(String type) {
    this.type = type;
  }

  private String getType() {
    return this.type;
  }
}

