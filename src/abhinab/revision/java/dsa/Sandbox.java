package abhinab.revision.java.dsa;

import java.util.*;

public class Sandbox {
  public static void main(String[] args) {
    System.out.println("permutations of 'ABC' are: " + Permutations.permute("ABC"));
    int[] array = new int[] {1, 2, 3};
    System.out.println("array: " + Arrays.toString(array));
    System.out.println("permutations of with list-of-integers (List<Integer>): " + Permutations.permute(array));
    System.out.println("permutations of with list-of-int_array (List<int[]>): " 
        + Permutations.permuteArr(array).stream()
            .map(arr -> Arrays.toString(arr))
            .toList()
    );
  }
}

