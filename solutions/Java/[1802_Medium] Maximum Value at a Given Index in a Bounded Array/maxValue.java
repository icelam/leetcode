class Solution {
  public int maxValue(int n, int index, int maxSum) {
    // Since abs(nums[i] - nums[i+1]) <= 1, we could emulate the result by continue
    // adding  1 to array by expanding the array step by step until we cannot evenly
    // spead the remaining sum to each column.
    //
    // Example 1: n = 6, index = 2, maxSum = 10
    // [2, 3, 2, 1, 1]
    //                Step 3 (c): Expand boundary by 1 starting from index,
    //   c         <-             add 1 to all elements within the boundary
    // c b c       <- Step 2 (b): add 1 to index
    // a a a a a a <- Step 1 (a): add 1 to all elements since nums[i] must be positive
    //
    // Example 2: n = 6, index = 1, maxSum = 10
    // [3, 3, 1, 1, 1]
    // c d         <- For any remaining sum that cannot be evenly spread across
    // b c            elements within boundary, we can stop the loop as it won't affect
    // a a a a a a    final result, for illustration, we also mark (d) as the final step
    //
    // Example 3: n = 4, index = 2, maxSum = 6
    // [2, 2, 1, 1]
    // c b
    // a a a a

    int left = index;
    int right = index;
    int result = 1;

    int remainingSum = maxSum - n;

    while ((left > 0 || right < n - 1) && remainingSum >= right - left + 1) {
      remainingSum -= right - left + 1;
      result++;
      left = Math.max(0, left - 1);
      right = Math.min(n - 1, right + 1);
    }

    // When number of element within boundary = nums.length, we can skip looping and
    // directly evenly spread remaining sum to all elements in nums
    result += remainingSum / n;
    return result;
  }
}
