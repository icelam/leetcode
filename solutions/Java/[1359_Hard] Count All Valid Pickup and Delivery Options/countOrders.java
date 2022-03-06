class Solution {
  public int countOrders(int n) {
    double result = 1;
    int mod = (int) Math.pow(10, 9) + 7;

    for (int i = 1; i <= 2 * n; i++) {
      result = (result * i / (i <= n ? 2 : 1)) % mod;
    }

    return (int) (result);
  }
}
