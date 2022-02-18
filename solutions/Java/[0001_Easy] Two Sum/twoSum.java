class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];

    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      int currentValue = nums[i];
      int remainingValue = target - currentValue;

      if (hashmap.containsKey(remainingValue) && hashmap.get(remainingValue) >= 0) {
        result[0] = hashmap.get(remainingValue);
        result[1] = i;
        break;
      } else {
        hashmap.put(currentValue, i);
      }
    }

    return result;
  }
}
