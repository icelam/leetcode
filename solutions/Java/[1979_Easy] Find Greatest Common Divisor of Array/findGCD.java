class Solution {
  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public int findGCD(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int n: nums) {
      min = Math.min(min, n);
      max = Math.max(max, n);
    }

    return gcd(min, max);
  }
}
