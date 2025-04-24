class Solution {
  public int countCompleteSubarrays(int[] nums) {
    int n = nums.length;
    HashSet<Integer> distinctNums = new HashSet<>();
    HashMap<Integer, Integer> frequency = new HashMap<>();
    int result = 0;
    int left = 0;
    int right = 0;

    for (int value : nums) {
      distinctNums.add(value);
    }

    int distinctCount = distinctNums.size();

    while (left < n) {
      if (left > 0) {
        frequency.put(nums[left - 1], frequency.get(nums[left - 1]) - 1);

        if (frequency.get(nums[left - 1]) == 0) {
          frequency.remove(nums[left - 1]);
        }
      }

      while (right < n && frequency.size() < distinctCount) {
        frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);
        right++;
      }

      if (frequency.size() == distinctCount) {
        result += (n - right + 1);
      }

      left++;
    }

    return result;
  }
}
