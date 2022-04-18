class Solution {
  public int removeDuplicates(int[] nums) {
    int length = nums.length;
    int current = 2;

    while (current < length) {
      if (nums[current - 1] == nums[current] && nums[current - 2] == nums[current]) {
        for (int i = current; i < length - 1; i++) {
          nums[i] = nums[i + 1];
        }
        length--;
      } else {
        current++;
      }
    }

    return length;
  }
}
