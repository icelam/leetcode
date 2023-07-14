class Solution {
  public int longestSubsequence(int[] arr, int difference) {
    // -10^4 <= arr[i], difference <= 10^4
    int[] dp = new int[40001];
    int result = 1;

    for (int num : arr) {
      int index = num + 20000;
      int previousLength = dp[index - difference];
      dp[index] = previousLength + 1;
      result = Math.max(result, dp[index]);
    }

    return result;
  }
}
