class Solution {
  public int minOperations(int[] nums, int k) {
    int xorResult = 0;

    for (int n: nums) {
      xorResult ^= n;
    }

    return Integer.bitCount(xorResult ^ k);
  }
}
