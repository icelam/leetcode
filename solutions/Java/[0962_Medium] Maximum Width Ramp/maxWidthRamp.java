class Solution {
  public int maxWidthRamp(int[] nums) {
    int n = nums.length;
    Integer[] indices = new Integer[n];

    for (int i = 0; i < n; i++) {
      indices[i] = i;
    }

    Arrays.sort(indices, (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);

    int minIndex = n;
    int result = 0;

    for (int i: indices) {
      result = Math.max(result, i - minIndex);
      minIndex = Math.min(minIndex, i);
    }

    return result;
  }
}
