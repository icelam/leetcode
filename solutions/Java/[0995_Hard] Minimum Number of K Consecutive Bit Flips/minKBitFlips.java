class Solution {
  public int minKBitFlips(int[] nums, int k) {
    /**
     * Greedy + difference array:
     * 1. Greedy: Flip whenever the first element of subarray of length k is zero
     * 2. When nums[i] is flipped even number of times, value remains unchanged.
     *    If it is flipped odd number of time, it becomes (nums[i] ^ 1)
     * 3. It's not efficient to update nums[i] everytime we flip it.
     *    A technique called difference array is best for recording frequent
     *    increase or decrease on elements in a range of an array.
     *    Consider you have to perform these steps on an array:
     *    - Increase 1 on nums[2..6]
     *    - Decrease 3 on nums[3..9]
     *    - Increase 4 onnnums[0..4]
     *    A very intuitive way is to use for loop and update value one by one.
     *    However, if we maintain difference array, we only need to:
     *    - int[] diff = new int[n + 1];
     *    - diff[0] = nums[0];
     *    - for (int i = 1; i < nums.length; i++) {
     *        diff[i] = nums[i] - nums[i - 1];
     *      }
     *    - diff[2] += 1;  diff[7] -= 1;
     *    - diff[3] += -3;  diff[10] -= -3;
     *    - diff[0] += 4;  diff[5] -= 4;
     *    Where diff[start] += val means applys val to nums[start..],
     *    then diff[end + 1] -= val means cancel applied val on nums[end..].
     *    It only takes O(1) time to modify diff array, and it is equivalent to
     *    modifying entire range of nums array which takes O(k) time.
     */
    int n = nums.length;
    // Difference Array
    int[] difference = new int[n + 1];
    // Total flips occured at nums[i]
    int currentFlip = 0;
    int totalFlipCount = 0;

    for (int i = 0; i < n; i++) {
      currentFlip += difference[i];
      // If nums[i] after all the flip is still 0, we need to continue flipping
      if ((currentFlip + nums[i]) % 2 == 0) {
        // Remaining space not enough to cancel current 0
        if (i + k > n) {
          return -1;
        }

        // Update difference array
        difference[i + 1]++;
        difference[i + k]--;

        // Increment total flip count
        totalFlipCount++;
      }
    }

    return totalFlipCount;
  }
}
