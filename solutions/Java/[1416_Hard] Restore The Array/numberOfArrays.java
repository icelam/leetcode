class Solution {
  private static int MOD = (int) (1e9 + 7);

  private int numberOfDigits(int n) {
   int result = 0;
    int num = n;

    while (num > 0) {
      num /= 10;
      result++;
    }

    return result;
  }

  private long toNumber(char[] chatacters, int start, int end) {
    long sum = 0;

    while (start < end) {
      sum = sum * 10 + (chatacters[start] - '0');
      start++;
    }

    return sum;
  }

  public int numberOfArrays(String s, int k) {
    int m = numberOfDigits(k);
    int n = s.length();
    char[] characters = s.toCharArray();
    long[] dp = new long[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = Math.max(0, i - m); j < i; j++) {
        if (characters[j] == '0') {
          continue;
        }

        long number = toNumber(characters, j, i);

        if (number >= 1 && number <= k) {
          dp[i] += dp[j];
          dp[i] %= MOD;
        }
      }
    }

    return (int) dp[n];
  }
}
