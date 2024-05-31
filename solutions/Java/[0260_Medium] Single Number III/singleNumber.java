class Solution {
  public int[] singleNumber(int[] nums) {
    int[] result = new int[2];
    int xorSum = 0;

    for (int x : nums) {
      xorSum ^= x;
    }

    // Lowbit:
    // The expression -x gives the two's complement of x, which is the negative of x.
    // For example, if x = 5 (binary 0101), then -x would be -5 (binary 1011).
    // When we perform the bitwise AND (&) operation between x and -x, it has the effect of isolating the rightmost set bit in x.
    int lowbit = xorSum & -xorSum;

    for (int x : nums) {
      // Utilize lowbit to group numbers and perfrom xor in groups accordingly
      result[(x & lowbit) == 0 ? 0 : 1] ^= x;
    }

    return result;
  }
}
