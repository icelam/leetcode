class Solution {
  public void swap(int[] nums, int left, int right) {
    if (left == right) {
      return;
    }

    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  private void generate(int[] nums, int left, int right, LinkedList<List<Integer>> result) {
    if (left == right) {
      List<Integer> list = new LinkedList<>();
      for (int n: nums) {
        list.add(n);
      }
      result.add(list);
    } else {
      int[] processedNums = new int[21];

      for (int i = left; i <= right; i++) {
        if (processedNums[nums[i] + 10] > 0) {
          continue;
        }
        processedNums[nums[i] + 10]++;
        swap(nums, left, i);
        generate(nums, left + 1, right, result);
        swap(nums, left, i);
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    generate(nums, 0, nums.length - 1, result);
    return result;
  }
}
