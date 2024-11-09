class Solution {
  public long minEnd(int n, int x) {
    long result = x;
    int i = n - 1;

    while (i > 0) {
      result = (result + 1) | x;
      i--;
    }

    return result;
  }
}
