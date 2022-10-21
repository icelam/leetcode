class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> positions = new HashMap<>();
    int length = nums.length;

    for (int i = 0; i < length; i++) {
      Integer previousPosition = positions.put(nums[i], i);
      if (previousPosition != null && i - previousPosition <= k) {
        return true;
      }
    }

    return false;
  }
}
