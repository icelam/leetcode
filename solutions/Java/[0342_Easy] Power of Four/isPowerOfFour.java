class Solution {
  public boolean isPowerOf2(int n) {
    return (n & (n - 1)) == 0;
  }

  public int countBits(int n) {
    int count = 0;

    while (n != 0) {
      n >>= 1;
      count++;
    }

    return count;
  }

  public boolean isPowerOfFour(int n) {
    return n > 0
      ? isPowerOf2(n) && countBits(n - 1) % 2 == 0
      : false;
  }
}
