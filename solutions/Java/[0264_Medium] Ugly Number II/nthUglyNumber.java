class Solution {
  public int nthUglyNumber(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;

    int pointer2 = 1;
    int pointer3 = 1;
    int pointer5 = 1;

    for (int i = 2; i <= n; i++) {
      int num2 = dp[pointer2] * 2;
      int num3 = dp[pointer3] * 3;
      int num5 = dp[pointer5] * 5;

      dp[i] = Math.min(Math.min(num2, num3), num5);

      if (dp[i] == num2) {
        pointer2++;
      }

      if (dp[i] == num3) {
        pointer3++;
      }

      if (dp[i] == num5) {
        pointer5++;
      }
    }

    return dp[n];
  }
}
