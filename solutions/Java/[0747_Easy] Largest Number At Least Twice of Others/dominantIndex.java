class Solution {
  public int dominantIndex(int[] nums) {
    int n = nums.length;
    int largestNum = -1;
    int secondLargestNum = -1;
    int largestNumIndex = -1;

    for (int i = 0; i < n; i++) {
      if (nums[i] > largestNum) {
        secondLargestNum = largestNum;
        largestNum = nums[i];
        largestNumIndex = i;
      } else if (nums[i] > secondLargestNum) {
        secondLargestNum = nums[i];
      }
    }

    if (largestNum / 2 >= secondLargestNum) {
      return largestNumIndex;
    }

    return -1;
  }
}
