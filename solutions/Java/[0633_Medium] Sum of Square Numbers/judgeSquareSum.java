class Solution {
  public boolean judgeSquareSum(int c) {
    int cSquareRoot = (int) Math.sqrt(c);

    for (int a = 0; a <= cSquareRoot; a++) {
      double b = Math.sqrt(c - (a * a));

      if (b == (int) b) {
        return true;
      }
    }

    return false;
  }
}
