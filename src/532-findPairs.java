class Solution {
  public int findPairs(int[] nums, int k) {
    HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      hashTable.put(nums[i], hashTable.getOrDefault(nums[i], 0) + 1);
    }

    int count = 0;

    for (int num: hashTable.keySet()) {
      if (k == 0 && hashTable.get(num) >= 2) {
        count++;
      } else if (k > 0 && hashTable.containsKey(num + k)) {
        count++;
      }
    }

    return count;
  }
}
