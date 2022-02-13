class Solution {
  private List<List<Integer>> result = new ArrayList<>();
  private List<Integer> queue = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    backtrack(0, nums);
    return result;
  }

  public void backtrack(int start, int[] nums) {
    result.add(new ArrayList<>(queue));

    for (int i = start; i < nums.length; i++) {
      queue.add(nums[i]);
      backtrack(i + 1, nums);
      queue.remove(queue.size() - 1);
    }
  }
}
