class Solution {
  public int minimumOperations(int[] nums) {
    int result = 0;

    for (int value: nums) {
      if (value % 3 != 0) {
        result++;
      }
    }

    return result;
  }
}
