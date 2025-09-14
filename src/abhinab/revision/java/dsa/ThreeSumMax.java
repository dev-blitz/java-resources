package abhinab.revision.java.dsa;

import java.util.*;

public class ThreeSumMax {
  public static int getThreeSum(int[] array) {
    if (array.length < 3) 
      throw new IllegalArgumentException("Array length must be at least 3");
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;
    for (int num : array) {
      if (num > max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num > max2) {
        max2 = num;
      } else if(num > max3) {
        max3 = num;
      }
    }
    System.out.printf("max1: %d, max2: %d, max3: %d\n", max1, max2, max3);
    return max1 + max2 + max3;
  }

  public static void main(String[] args) {
    int[] array = new int[] {99, 100, 101, 5, 102, 11, 78};
    System.out.println("array: " + Arrays.toString(array));
    System.out.println("three-sum: " + getThreeSum(array));
  }
}

