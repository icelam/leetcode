class Solution {
  public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    int n = arr.length;
    Arrays.sort(arr);

    int[] result = new int[n];
    System.arraycopy(arr, 0, result, 0, n);
    result[0] = 1;

    for (int i = 1; i < n; i++) {
      if (result[i] - result[i - 1] > 1) {
        result[i] = result[i - 1] + 1;
      }
    }

    return result[n - 1];
  }
}
