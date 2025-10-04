package blitz.revision.java_resources.comparator_comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorComparableDemo {
  
  private static class Student implements Comparable<Student> {
    private String firstName;
    private String middleName;
    private String lastName; 
    private int standard;

    public Student(String firstName, String lastName, int standard) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.standard = standard;
    }

    public Student(String firstName, String middleName, String lastName, int standard) {
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.standard = standard;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getMiddleName() {
      return middleName;
    }
    
    public String getLastName() {
      return lastName;
    }

    public int getStandard() {
      return standard;
    }

    @Override
    public int compareTo(Student student) {
      return this.firstName.compareTo(student.firstName) * -1;
    }

    @Override
    public String toString() {
      return "student: [\n\tname:" +
        firstName + " " + (middleName == null ? "" : middleName + " ") +
        lastName + "\n\tstandard: " + standard + "\n]";
    }
  }

  private static class DescStudComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
      return -1 * s1.getFirstName().compareTo(s2.getFirstName());
    }
  }
  
  public static void main(String[] args) {
    List<Student> students = Arrays.asList(
      new Student("Abhinab", "Dutta", "Gupta", 6),
      new Student("Arunima", "Barman", 6),
      new Student("zzz", "l", 6)
    );
    System.out.println("before-sort: " + students);
    Collections.sort(students);
    System.out.println("after-sort: " + students);
    
    Comparator<Student> ascStudComparator = ((s1, s2) -> {
      return s1.getFirstName().compareTo(s2.getFirstName());
    });

    Comparator<Student> ascComp = new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return s1.getFirstName().compareTo(s2.getFirstName());
      }
    };

    Collections.sort(students, ascStudComparator);
    System.out.println("ascending-comparator-sort: " + students);
    Collections.sort(students, new DescStudComparator());
    System.out.println("descending-comparator-sort: " + students);
    Collections.sort(students, ascComp);
    System.out.println("asc-conv: " + students);
    Collections.sort(students, ((s1, s2) -> (-1 * s1.getFirstName().compareTo(s2.getFirstName()))));
    System.out.println("students: " + students);
  }
}

