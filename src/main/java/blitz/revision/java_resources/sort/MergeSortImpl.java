package blitz.revision.java_resources.sort;

import java.util.Arrays;

public class MergeSortImpl {

  public static void main(String[] args) {
    int[] array = new int[] {24, 38, 11, 9, 63, 36, 48, 12, 54, 99, 1};
    System.out.println("original-array: " + Arrays.toString(array));
    System.out.println("sorted-array: " + Arrays.toString(sort(array)));
  }

  private static int[] sort(int[] array) {
    return sort(array, 0, array.length - 1);
  }

  private static int[] sort(int[] array, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      sort(array, left, mid);
      sort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
    return array;
  }

  private static void merge(int[] array, int left, int mid, int right) {
    int[] leftArr = new int[mid - left + 1];
    for (int i = 0; i < leftArr.length; i++)
      leftArr[i] = array[left + i];

    int[] rightArr = new int[right - mid];
    for (int i = 0; i < rightArr.length; i++)
      rightArr[i] = array[mid + 1 + i];

    int x = 0;
    int y = 0;
    int z = left;

    while (x < leftArr.length && y < rightArr.length) {
      if (leftArr[x] < rightArr[y]) {
        array[z++] = leftArr[x++];
      } else {
        array[z++] = rightArr[y++];
      }
    }

    while (x < leftArr.length) {
      array[z++] = leftArr[x++];
    }

    while (y < rightArr.length) {
      array[z++] = rightArr[y++];
    }
  }
}
