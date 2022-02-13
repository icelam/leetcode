class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<Integer>());

    for (int n: nums) {
      List<List<Integer>> queue = new ArrayList<>();

      for (List<Integer> subset: result) {
        List<Integer> newSubset = new ArrayList<>(subset);
        newSubset.add(n);
        queue.add(newSubset);
      }

      for (List<Integer> subset: queue) {
        result.add(subset);
      }
    }

    return result;
  }
}
