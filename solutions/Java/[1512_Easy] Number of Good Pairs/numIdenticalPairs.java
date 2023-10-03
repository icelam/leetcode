class Solution {
  public int numIdenticalPairs(int[] nums) {
    HashMap<Integer, Integer> frequency = new HashMap<>();

    for (int num: nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }

    int result = 0;

    for (int key: frequency.keySet()) {
      int count = frequency.get(key);

      if (count > 1) {
        int n = count - 1;
        result += n * ((1 + n) / 2.0);
      }
    }

    return result;
  }
}
