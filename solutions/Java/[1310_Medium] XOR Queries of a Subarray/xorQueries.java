class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
    int m = queries.length;
    int n = arr.length;
    int[] prefixSum = new int[n];
    prefixSum[0] = arr[0];

    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] ^ arr[i];
    }

    int[] result = new int[m];

    for (int i = 0; i < m; i++) {
      int left = queries[i][0];
      int right = queries[i][1];

      if (left == 0) {
        result[i] = prefixSum[right];
      } else {
        result[i] = prefixSum[right] ^ prefixSum[left - 1];
      }
    }

    return result;
  }
}
