class Solution {
  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    int[] sum = new int[1001];
    int m = 0;

    for (int[] pair: nums1) {
      if (sum[pair[0]] == 0) {
        m++;
      }

      sum[pair[0]] += pair[1];
    }

    for (int[] pair: nums2) {
      if (sum[pair[0]] == 0) {
        m++;
      }

      sum[pair[0]] += pair[1];
    }

    int[][] result = new int[m][2];

    for (int i = 1000; i >= 1; i--) {
      if (sum[i] == 0) {
        continue;
      }

      result[m - 1][0] = i;
      result[m - 1][1] = sum[i];
      m--;
    }

    return result;
  }
}
