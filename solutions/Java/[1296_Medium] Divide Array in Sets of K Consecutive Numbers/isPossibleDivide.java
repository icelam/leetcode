class Solution {
  public boolean isPossibleDivide(int[] nums, int k) {
    int n = nums.length;

    if (n % k != 0) {
      return false;
    }

    if (n == 1) {
      return true;
    }

    Arrays.sort(nums);

    Map<Integer, Integer> frequency = new HashMap<>();

    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }

    for (int num: nums) {
      if (frequency.get(num) > 0) {
        int count = frequency.get(num);

        for (int i = 0; i < k; i++) {
          if (frequency.getOrDefault(num + i, 0) < count) {
            return false;
          }

          frequency.put(num + i, frequency.get(num + i) - count);
        }
      }
    }

    return true;
  }
}
