class Solution {
  public int wiggleMaxLength(int[] nums) {
    int n = nums.length;

    if (n < 2) {
      return nums.length;
    }

    int previousDiff = nums[1] - nums[0];
    int count = previousDiff != 0 ? 2 : 1;

    for (int i = 2; i < n; i++) {
      int newDiff = nums[i] - nums[i - 1];

      if ((newDiff > 0 && previousDiff <= 0) || (newDiff < 0 && previousDiff >= 0)) {
        count++;
        previousDiff = newDiff;
      }
    }

    return count;
  }
}
