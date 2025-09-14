package abhinab.revision.java.dsa;

import java.util.*;

public class Permutations {
  public static List<String> permute(String str) {
    return permute(str, 0, str.length() - 1, new ArrayList<String>());
  }

  public static List<String> permute(String str, int left, int right, List<String> permutations) {
    if (left == right) {
      if (!permutations.contains(str)) {
        permutations.add(str);
      }
    } else if (left < right) {
      for (int i = left; i <= right; i++) {
        str = swap(str, left, i);
        permute(str, left + 1, right, permutations);
        str = swap(str, left, i);
      }
    }
    return permutations;
  }

  public static String swap(String str, int left, int right) {
    char[] array = str.toCharArray();
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
    return String.valueOf(array);
  }

  public static List<List<Integer>> permute(int[] array) {
    return permute(array, 0, array.length - 1, new ArrayList<List<Integer>>());
  }

  public static List<List<Integer>> permute(int[] array, int left, int right, List<List<Integer>> permutations) {
    if (left == right) {
      List<Integer> combination = Arrays.stream(array)
        .boxed()
        .toList();
      if (!permutations.contains(combination)) {
        permutations.add(combination);
      }
    } else {
      for (int i = left; i <= right; i++) {
        array = swap(array, left, i);
        permute(array, left + 1, right, permutations);
        array = swap(array, left, i);
      }
    }
    return permutations;
  }

  public static List<int[]> permuteArr(int[] array) {
    return permuteArr(array, 0, array.length - 1, new ArrayList<int[]>());
  }

  public static List<int[]> permuteArr(int[] array, int left, int right, List<int[]> permutations) {
    if (left == right) {
      int[] combination = array.clone();
      if (!permutations.contains(combination)) {
        permutations.add(combination);
      }
    } else {
      for (int i = left; i <= right; i++) {
        array = swap(array, left,i); 
        permuteArr(array, left + 1, right, permutations);
        array = swap(array, left,i); 
      }
    }
    return permutations;
  }

  public static int[] swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
    return array;
  }
}

