public class Solution {
  public int reverseBits(int n) {
    int result = 0;

    for (int i = 31; i >= 0; i--) {
      result |= (n & 1) << i;
      n >>= 1;
    }

    return result;
  }
}
