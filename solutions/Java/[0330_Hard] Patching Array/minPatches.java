class Solution {
  public int minPatches(int[] nums, int n) {
    int patchCount = 0;
    long nextRequiredNum = 1;
    int m = nums.length;
    int pointer = 0;

    /*
     * For any number in the range [1, n] inclusive to be able to form by the sum of SOME elements in the array `nums`:
     * Start thinking from empty nums (nums = [])
     * To form 1 -> [1]           // Add 1 to nums, sum of nums = 1
     * To form 2 -> [1,2]         // Add 2 to nums, sum of nums = 3
     * To form 3 -> [1,2]         // Add nothing, already covers 3 (1 + 2)
     * To form 4 -> [1,2,4]       // Add 4 to nums, sum of nums = 7
     * To form 5 -> [1,2,4]       // Add nothing, already covers 5 (1 + 4)
     * To form 6 -> [1,2,4]       // Add nothing, already covers 6 (2 + 4)
     * To form 7 -> [1,2,4]       // Add nothing, already covers 7 (1 + 2 + 4)
     * To form 8 -> [1,2,4,8]     // Add 7 to nums, sum of nums = 15
     * To form 9 -> [1,2,4,8]     // Add nothing, already covers 9 (1 + 9)
     * To form 10 -> [1,2,4,8]    // Add nothing, already covers 10 (2 + 8)
     * To form 11 -> [1,2,4,8]    // Add nothing, already covers 11 (1 + 2 + 9)
     * To form 12 -> [1,2,4,8]    // Add nothing, already covers 12 (4 + 8)
     * To form 13 -> [1,2,4,8]    // Add nothing, already covers 13 (1 + 4 + 8)
     * To form 14 -> [1,2,4,8]    // Add nothing, already covers 14 (2 + 4 + 8)
     * To form 15 -> [1,2,4,8]    // Add nothing, already covers 15 (1 + 2 + 4 + 8)
     * To form 16 -> [1,2,4,8,16] // Add 16 to nums, sum of nums = 31
     *
     * Observation:
     * 1. Adding `sum(nums) + 1` to `nums` will allow SOME elements of its
     * to form any number in the range [1, sum(nums) * 2 + 1] continuously.
     * In other words, if the next number to add is `4`, then it already supports
     * forming any number in range [1, 3]
     * Whenever n > sum(nums), Add `sum(nums) + 1` until sum(nums) >= n.
     * 2. Numbers added to `nums` are continuous powers of 2 (2^n).
     * 3. Newly added number is (or MUST NOT exceed) twice of previous number
     *
     * What if `nums` is not empty? Consider example 2:
     * Input: nums = [1,5,10], n = 20
     * Output: 2
     * If we have to change all the numbers to continuous powers of 2,
     * nums = [1,2,4], it will only support forming numbers < sum([1,2,4]),
     * and we will have to add 8 and 16 to reach the requirement of forming any number within [1, n = 20].
     * Which requires 4 patches. Which is obviously more than the expected output.
     * Is there another way which we can avoid changing existing numbers?
     * In index[0] = 1, we can form 1.
     * Then in index[1] = 5, we cannot form 2, 3, 4. So we patch and add 2.
     * We now can form numbers up to 3, still we need to patch and add 4 to nums.
     * We now support forming 1 - 7 by [1, 2, 4, 5, 7].
     * Then we head to index[2] = 5, from the previous observation,
     * we know that when a number in the existing `nums` array can support forming 1 to x,
     * then adding a new number y to the array will extend its supported range 1 to x + y.
     * We leave index[2] unchanged. We are sure we support forming 1 - 13.
     * We now need a number that is >= 7 to reach the requirement n = 20.
     * Since index[3] > 7, we can also leave it unchanged.
     * Therefore, the minimum number of patches is 2, where the patches are to add [2, 4].
     */

    // Numbers that can be covered continuously has not reached n.
    // Two possibilities can lead to this:
    // 1. Missing number in array which previois sum cannot form continuous numbers
    // 2. The next required number has not been added
    while (nextRequiredNum <= n) {
      if (pointer >= m || nums[pointer] > nextRequiredNum) {
        patchCount++;
        nextRequiredNum *= 2;
        continue;
      }

      nextRequiredNum += nums[pointer];
      pointer++;
    }

    return patchCount;
  }
}
