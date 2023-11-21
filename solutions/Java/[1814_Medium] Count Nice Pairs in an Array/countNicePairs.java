class Solution {
  private static int MOD = (int) (1e9 + 7);

  private int reverse(int num) {
    int result = 0;

    while (num != 0) {
      int digit = num % 10;
      result = result * 10 + digit;
      num /= 10;
    }

    return result;
  }

  public int countNicePairs(int[] nums) {
    HashMap<Integer, Integer> frequency = new HashMap<>();

    for (int num: nums) {
      int difference = num - reverse(num);
      frequency.put(difference, frequency.getOrDefault(difference, 0) + 1);
    }

    long result = 0;

    for (int n: frequency.values()) {
      // Arithimetic sum formula to calculate sum of 1 to (n - 1),
      // since nCr(n = 4, r = 2) is (ab, ac, ad) + (bc, bd) + (cd),
      // which is 3 + 2 + 1 = 6
      // While the original formula for calculating n is (n * (n + 1)) / 2,
      // n - 1 can be written as ((n - 1) * n) / 2
      result += (long) (n - 1) * n / 2;
      result %= MOD;
    }

    return (int) result;
  }
}
