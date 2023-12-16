class Solution {
  public List<Integer> targetIndices(int[] nums, int target) {
    int n = nums.length;
    int smallerCount = 0;
    int largerCount = 0;

    for (int value: nums) {
      if (value < target) {
        smallerCount++;
      } else if (value > target) {
        largerCount++;
      }
    }

    List<Integer> result = new ArrayList<>();

    for (int i = smallerCount; i < n - largerCount; i++) {
      result.add(i);
    }

    return result;
  }
}
