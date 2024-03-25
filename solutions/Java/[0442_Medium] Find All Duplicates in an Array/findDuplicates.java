class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      while (nums[i] != nums[nums[i] - 1]) {
        int currentNum = nums[i];
        nums[i] = nums[currentNum - 1];
        nums[currentNum - 1] = currentNum;
      }
    }

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        result.add(nums[i]);
      }
    }

    return result;
  }
}
