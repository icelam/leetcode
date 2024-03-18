class Solution {
  public int[] replaceElements(int[] arr) {
    int n = arr.length;
    int max = -1;
    int[] result = new int[n];


    for (int i = n - 1; i >= 0; i--) {
      result[i] = max;

      if (arr[i] > max) {
        max = arr[i];
      }
    }

    return result;
  }
}
