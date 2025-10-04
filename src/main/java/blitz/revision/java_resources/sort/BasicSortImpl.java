package blitz.revision.java_resources.sort;

import java.util.Arrays;

public class BasicSortImpl {
  public static void main(String[] args) {
    int[] array = new int[]{1, 33, 2, 66, 6, 11};
    System.out.println("original-array: " + Arrays.toString(array));
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
    System.out.println("sorted-array: " +Arrays.toString(array));
  }
}

