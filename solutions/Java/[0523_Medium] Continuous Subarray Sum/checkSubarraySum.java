class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);

    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      // Finding the same remainder is equivalent to finding a continuous prefix sum that is a multiple of k.
      // Assume sum(abc) % k == sum(abcdef) % k == rem, then they satisfy the following properties:
      // a + b + c = x * k + rem
      // a + b + c + d + e + f = y * k + rem
      //
      // sum(abcdef) - sum(abc)
      // = (y * k + rem) - (x * k + rem)
      // = y * k - x * k
      // = (y - x) * k
      //
      // We have thus found a continuous subarray whose sum is a multiple of k.
      if (!map.containsKey(sum % k)) {
        map.put(sum % k, i + 1);
      } else if (map.get(sum % k) < i) {
        // Only consider subarray length >= 2
        return true;
      }
    }

    return false;
  }
}
