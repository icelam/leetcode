class Solution {
  public String getSmallestString(int n, int k) {
    char[] result = new char[n];

    // Assume remaining space are filled with z
    // if remaining <= 0, filling with z is wrong and (1-indexed)
    for (int i = n - 1, j = 0; i >= 0; i--, j++) {
      int remaining = k - 26 * i;

      if (remaining > 0) {
        result[j] = (char) ('a' + remaining - 1);
        k -= remaining;
      } else {
        result[j] = 'a';
        k--;
      }
    }

    return new String(result);
  }
}
