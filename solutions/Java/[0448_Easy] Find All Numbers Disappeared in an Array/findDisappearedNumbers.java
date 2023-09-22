class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    int n = nums.length;
    int[] frequency = new int[n + 1];
    List<Integer> result = new ArrayList<>();

    for (int num: nums) {
      frequency[num]++;
    }

    for (int i = 1; i <= n; i++) {
      if (frequency[i] == 0) {
        result.add(i);
      }
    }

    return result;
  }
}
