class Solution {
  public int countPairs(List<Integer> nums, int target) {
    // Although the requirement specify i < j, it doesn't matter to sort the nums
    // since you can always swap (i, j) pair to satisfy the requirement
    Collections.sort(nums);

    int n = nums.size();
    int result = 0;
    int i = 0;
    int j = n - 1;

    while (i < j) {
      while (i < j && nums.get(i) + nums.get(j) >= target) {
        j--;
      }

      result += j - i;
      i++;
    }

    return result;
  }
}
