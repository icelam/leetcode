class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int knightDialer(int n) {
    int[] previousCount = new int[10];
    Arrays.fill(previousCount, 1);

    for (int i = 2; i <= n; i++) {
      int[] count = new int[10];
      count[0] = (previousCount[4] + previousCount[6]) % MOD;
      count[1] = (previousCount[6] + previousCount[8]) % MOD;
      count[2] = (previousCount[7] + previousCount[9]) % MOD;
      count[3] = (previousCount[4] + previousCount[8]) % MOD;
      count[4] = (((previousCount[0] + previousCount[3]) % MOD) + previousCount[9]) % MOD;
      count[6] = (((previousCount[0] + previousCount[1]) % MOD) + previousCount[7]) % MOD;
      count[7] = (previousCount[2] + previousCount[6]) % MOD;
      count[8] = (previousCount[1] + previousCount[3]) % MOD;
      count[9] = (previousCount[2] + previousCount[4]) % MOD;
      previousCount = count;
    }

    int result = 0;

    for (int i = 0; i < 10; i++) {
      result += previousCount[i];
      result %= MOD;
    }

    return result;
  }
}
