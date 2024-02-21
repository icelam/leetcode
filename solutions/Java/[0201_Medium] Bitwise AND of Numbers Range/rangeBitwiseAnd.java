class Solution {
  public int rangeBitwiseAnd(int left, int right) {
    int shift = 0;

    /* Example: left = 9, right = 12
     *  9:     1001
     * 10:     1010
     * 11:     1011
     * 12:     1100
     * result: 1000 (8)
     * Notice the result is actually common prefix of all numbers.
     * Since a range `left, left + n`, where n >= 1, must have both 0 and 1 appear in the suffix. And AND (&) operation will only result in 0.
     * We can utilize this characteristic to find the common prefix of both left and right number, and shift the result to it's original position.
     */
    while (left < right) {
      left >>= 1;
      right >>= 1;
      shift++;
    }

    return left << shift;
  }
}
