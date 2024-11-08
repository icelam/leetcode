class Solution {
  public int[] getMaximumXor(int[] nums, int maximumBit) {
    int n = nums.length;
    int mask = (1 << maximumBit) - 1;
    int xorsum = 0;

    for (int value: nums) {
      xorsum ^= value;
    }

    int[] result = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      result[n - 1 - i] = xorsum ^ mask;
      xorsum ^= nums[i];
    }

    return result;
  }
}
