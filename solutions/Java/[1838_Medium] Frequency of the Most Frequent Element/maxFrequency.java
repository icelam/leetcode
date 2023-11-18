class Solution {
  public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);

    int n = nums.length;
    int maxFrequency = 1;
    long windowSum = 0;
    int left = 0;

    for (int right = 1; right < n; right++) {
      // Calculate sum of differece for each value comapred to last element
      // We multiply (right - left) here since:
      // Consider [1, 2, 4]
      // Step 1: (nums[1] - nums[0]) * (1 - 0) = 1
      // Step 2: (nums[2] - nums[1]) * (2 - 0) = 4
      //         -> 4 can be consider as "Add 2 to both nums[0] and nums[1]"
      //         -> In step 1 we consider the difference between nums[0] and nums[1],
      //            and stored it into `windowSum`, which is same effect as changing
      //            nums[0] to nums[1], which means we have two value of 2 now.
      windowSum += (nums[right] - nums[right - 1]) * (right - left);


      // If value exceed:
      // 1. remove the differene of left most element compared to last element
      // 2. shift left boundary
      while (windowSum > k) {
        windowSum -= nums[right] - nums[left];
        left++;
      }

      maxFrequency = Math.max(maxFrequency, right - left + 1);
    }

    return maxFrequency;
  }
}
