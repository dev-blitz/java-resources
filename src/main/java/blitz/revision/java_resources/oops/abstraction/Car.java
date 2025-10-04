package blitz.revision.java_resources.oops.abstraction;

public class Car extends Vehicle {
  private String model;
  public int manufacturteYear;

  public Car(String name, VehicleType type, int cc, String model, int manufacturteYear) {
    super(name, type);
    this.model = model;
    this.manufacturteYear = manufacturteYear;
  }

  @Override
  public void drive() {
    System.out.printf("driving %s...\n", super.getType());
  }
}

