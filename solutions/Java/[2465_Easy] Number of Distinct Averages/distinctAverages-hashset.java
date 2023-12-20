class Solution {
  public int distinctAverages(int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = n - 1;
    HashSet<Double> result = new HashSet<>();

    Arrays.sort(nums);

    while (left < right) {
      result.add(((double) nums[left] + nums[right]) / 2);
      left++;
      right--;
    }

    return result.size();
  }
}
