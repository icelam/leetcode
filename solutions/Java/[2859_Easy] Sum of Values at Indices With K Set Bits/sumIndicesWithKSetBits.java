class Solution {
  private int bitCount(int n) {
    int count = 0;

    while (n != 0) {
      count += n & 1;
      n >>>= 1;
    }

    return count;
  }

  public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
    int n = nums.size();
    int result = 0;

    for (int i = 0; i < n; i++) {
      if (bitCount(i) == k) {
        result += nums.get(i);
      }
    }

    return result;
  }
}
