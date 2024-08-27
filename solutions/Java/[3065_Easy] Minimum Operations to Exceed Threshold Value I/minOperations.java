class Solution {
  public int minOperations(int[] nums, int k) {
    int count = 0;

    for (int value: nums) {
      if (value < k) {
        count++;
      }
    }

    return count;
  }
}
