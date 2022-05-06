class Solution {
  public void generate(List<List<Integer>> result, List<Integer> nums, int n, int k, int start) {
    if (k == 0) {
      result.add(new ArrayList<>(nums));
      return;
    }

    for (int i = start; i <= n - k + 1; i++) {
      nums.add(i);
      generate(result, nums, n, k - 1, i + 1);
      nums.remove(nums.size() - 1);
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    generate(result, new ArrayList<Integer>(), n, k, 1);
    return result;
  }
}
