class Solution {
  public int minimumOneBitOperations(int n) {
    if (n == 0) {
      return 0;
    }

    int x = Integer.toBinaryString(n).length() - 1;
    return (1 << (x + 1)) - 1 - minimumOneBitOperations(n - (1 << x));
  }
}
