class Solution {
  public int subarraySum(int[] nums, int k) {
    int prefixSum = 0;
    int count = 0;
    HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
    hashTable.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
      prefixSum = prefixSum + nums[i];
      count += hashTable.getOrDefault(prefixSum - k, 0);
      hashTable.put(prefixSum, hashTable.getOrDefault(prefixSum, 0) + 1);
    }

    return count;
  }
}
