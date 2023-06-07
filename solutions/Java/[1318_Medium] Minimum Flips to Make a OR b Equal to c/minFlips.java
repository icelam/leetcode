class Solution {
  public int minFlips(int a, int b, int c) {
    int result = 0;

    while (a != 0 || b != 0 || c != 0) {
      int bit1 = a & 1;
      int bit2 = b & 1;
      int target = c & 1;

      if (target != (bit1 | bit2)) {
        if (target == 0) {
          result += bit1 + bit2;
        } else {
          result++;
        }
      }

      a >>= 1;
      b >>= 1;
      c >>= 1;
    }

    return result;
  }
}
