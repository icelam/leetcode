class Solution {
  public List<Integer> majorityElement(int[] nums) {
    HashMap<Integer, Integer> frequency = new HashMap<>();
    int n = nums.length;
    int m = n / 3;
    List<Integer> result = new ArrayList<>();

    for (int num: nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }

    for (int num: frequency.keySet()) {
      if (frequency.get(num) > m) {
        result.add(num);
      }
    }

    return result;
  }
}
