class Solution {
  public int arithmeticSum(int start, int end) {
    return (end - start + 1) * (start + end) / 2;
  }

  public int pivotInteger(int n) {
    for (int i = n; i >= 1; i--) {
      if (arithmeticSum(1, i) == arithmeticSum(i, n)) {
        return i;
      }
    }

    return -1;
  }
}
