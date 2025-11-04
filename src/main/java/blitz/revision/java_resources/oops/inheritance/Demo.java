package blitz.revision.java_resources.oops.inheritance;

public class Demo {

    public static void main(String[] args) {
        Vehicle obj = new Car("Thar", 1000);
        System.out.println(obj.getTypeName());
        System.out.println(obj.getDetails());
        System.out.println();
        obj.drive();
        obj.park();
        System.out.println("\tdemo-ends");
    }
}
