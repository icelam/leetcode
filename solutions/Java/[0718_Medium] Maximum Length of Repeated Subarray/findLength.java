class Solution {
  public int findLength(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int result = 0;
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (nums1[i] == nums2[j]) {
          int k = i + 1;
          int l = j + 1;

          dp[k][l] = dp[i][j] + 1;

          if (result < dp[k][l]) {
            result = dp[k][l];
          }
        }
      }
    }

    return result;
  }
}
