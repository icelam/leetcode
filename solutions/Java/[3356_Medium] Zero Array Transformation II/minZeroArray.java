class Solution {
  public int minZeroArray(int[] nums, int[][] queries) {
    int n = nums.length;
    int m = queries.length;
    int[] diff = new int[n + 1];
    int sumDiff = 0;
    int k = 0;

    for (int i = 0; i < n; i++) {
      int currentValue = nums[i];
      sumDiff += diff[i];

      while (k < m && sumDiff < currentValue) {
        int[] currentQuery = queries[k];
        int start = currentQuery[0];
        int end = currentQuery[1];
        int queryValue = currentQuery[2];

        diff[start] += queryValue;
        diff[end + 1] -= queryValue;

        if (start <= i && i <= end) {
          sumDiff += queryValue;
        }

        k++;
      }

      if (sumDiff < currentValue) {
        return -1;
      }
    }

    return k;
  }
}
