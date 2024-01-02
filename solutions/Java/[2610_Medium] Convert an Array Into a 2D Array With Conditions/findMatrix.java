class Solution {
  public List<List<Integer>> findMatrix(int[] nums) {
    int[] frequency = new int[nums.length + 1];
    List<List<Integer>> result = new ArrayList<>();

    for (int n : nums) {
      if (frequency[n] >= result.size()) {
        result.add(new ArrayList<>());
      }

      result.get(frequency[n]).add(n);
      frequency[n]++;
    }

    return result;
  }
}
