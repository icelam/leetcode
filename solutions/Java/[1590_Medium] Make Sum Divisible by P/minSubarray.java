class Solution {
  public int minSubarray(int[] nums, int p) {
    int n = nums.length;
    int totalSum = 0;

    for (int num : nums) {
      totalSum = (totalSum + num) % p;
    }

    int target = totalSum % p;

    if (target == 0) {
      return 0;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int currentSum = 0;
    int result = n;

    for (int i = 0; i < n; i++) {
      currentSum = (currentSum + nums[i]) % p;
      int needed = (currentSum - target + p) % p;

      if (map.containsKey(needed)) {
        result = Math.min(result, i - map.get(needed));
      }

      map.put(currentSum, i);
    }

    return result == n ? -1 : result;
  }
}
