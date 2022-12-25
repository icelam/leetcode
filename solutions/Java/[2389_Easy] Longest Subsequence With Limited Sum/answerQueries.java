class Solution {
  public int binarySearch(int[] nums, int left, int right, int target) {
    while (left < right) {
      int middle = (left + right) / 2;

      if (nums[middle] == target) {
        return middle + 1;
      }

      if (target < nums[middle]) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return nums[left] > target ? left : left + 1;
  }

  public int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);
    int numsLength = nums.length;
    int queriesLength = queries.length;
    int[] prefixSum = new int[numsLength];
    prefixSum[0] = nums[0];

    for (int i = 1; i < numsLength; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    int[] result = new int[queriesLength];

    for (int i = 0; i < queriesLength; i++) {
      result[i] = binarySearch(prefixSum, 0, numsLength - 1, queries[i]);
    }

    return result;
  }
}
