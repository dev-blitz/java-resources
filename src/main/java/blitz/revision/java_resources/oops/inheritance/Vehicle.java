package blitz.revision.java_resources.oops.inheritance;

public interface Vehicle {
    default String getTypeName() {
        return this.getClass().getName();
    }
    void drive();
    void park();
    String getDetails();
}

