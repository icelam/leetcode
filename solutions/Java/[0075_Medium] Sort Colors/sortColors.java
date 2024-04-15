class Solution {
  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }

  public void sortColors(int[] nums) {
    int n = nums.length;

    if (n == 1) {
      return;
    }

    int left = 0;
    int right = n - 1;
    int i = 0;

    while (i <= right) {
      if (nums[i] == 2) {
        swap(nums, right, i);
        right--;
        continue;
      }

      if (nums[i] == 0) {
        swap(nums, left, i);
        left++;
      }

      i++;
    }
  }
}
