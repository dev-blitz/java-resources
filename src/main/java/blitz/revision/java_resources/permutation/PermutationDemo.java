package blitz.revision.java_resources.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationDemo {
  
  public static void main(String[] args) {
     String word = "ABC";
     System.out.printf("word: %s\n\t permutations of word: %s\n", word, permute(word));
  }

  private static List<String> permute(String str) {
    return permute(str, 0, str.length() - 1, new ArrayList<>());
  }

  private static List<String> permute(String str, int left, int right, List<String> result) {
    if (left < right) {
      for (int i = left; i <= right; i++) {
        str = swap(str, left, i);
        permute(str, left + 1, right, result);
        str = swap(str, left, i);
      }
    } else if (left == right) {
      if (!result.contains(str)) {
        result.add(str);
      }
    }

    return result;
  }

  private static String swap(String str, int left, int right) {
    char[] array = str.toCharArray();
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;

    return String.valueOf(array);
  }
}

