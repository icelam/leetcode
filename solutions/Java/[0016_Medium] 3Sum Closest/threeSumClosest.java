class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int length = nums.length;

    Arrays.sort(nums);

    int result = nums[0] + nums[1] + nums[2];

    for (int i = 0; i < length - 2; i++) {
      int left = i + 1;
      int right = length - 1;

      while (left != right && result != target) {
        int sum = nums[i] + nums[left] + nums[right];

        if (Math.abs(target - sum) < Math.abs(target - result)) {
          result = sum;
        }

        if (sum > target) {
          right--;
        } else {
          left++;
        }
      }
    }

    return result;
  }
}
