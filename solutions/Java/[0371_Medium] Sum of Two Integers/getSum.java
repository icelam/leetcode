class Solution {
  public int getSum(int a, int b) {
    /**
     * Explaination
     *
     * Look at the below possible combinations for adding single bits together:
     * 0 + 0 = 0
     * 0 + 1 = 1
     * 1 + 0 = 1
     * 1 + 1 = 0 (carry)
     *
     * Notice the pattern is a ^ b, with special case which 1 + 1 will produce carry.
     *
     * To find carry, we can do a & b since:
     * 0 & 0 = 0
     * 0 & 1 = 0
     * 1 & 0 = 0
     * 1 & 1 = 1
     *
     * Notice that in only 1 & 1 results in 1,
     * which fit the case where only 1 + 1 needs carry over.
     * To handle carry, simply left shift a & b.
     */
     while (b != 0) {
      int carry = (a & b) << 1;
      a = a ^ b;
      b = carry;
    }

    return a;
  }
}
