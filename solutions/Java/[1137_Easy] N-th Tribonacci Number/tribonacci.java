class Solution {
  private static int[] f = new int[38];

  public int tribonacci(int n) {
    if (n == 0) {
      return 0;
    }

    if (n == 1 || n == 2) {
      return 1;
    }

    if (f[n] > 0) {
      return f[n];
    }

    f[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);

    return f[n];
  }
}
