class Solution {
  public int subarraysDivByK(int[] nums, int k) {
    int[] map = new int[k];
    map[0] = 1;

    int size = nums.length;
    int sum = 0;
    int result = 0;

    for (int i = 0; i < size; i++) {
      sum += nums[i];
      // Take modulo twice to avoid negative remainders
      int remainder = ((sum % k) + k) % k;
      result += map[remainder];
      map[remainder]++;
    }

    return result;
  }
}
