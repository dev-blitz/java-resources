package abhinab.revision.java.dsa;

public class TwoSumMax {
  public static void main(String[] args) {
    int[] array = new int[] {0, 21, 1, 3, 11, 2, 7, 6};
  }

  public static int twoSumMax(int[] array) {
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    
    for (int i : array) {
      if(i > max1) {
        max2 = max1;
        max1 = i;
      } else if (i > max2) {
        max2 = i;
      }
    }

    return max1 + max2;
  }
}

