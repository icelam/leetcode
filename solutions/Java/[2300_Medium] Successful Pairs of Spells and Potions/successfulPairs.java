class Solution {
  public int binarySearch(int[] nums, double target) {
    int length = nums.length;

    int left = 0;
    int right = length - 1;
    int middle = nums.length / 2;

    while (left <= right) {
      middle = left + (right - left) / 2;

      if (target <= nums[middle]) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int n = spells.length;
    int m = potions.length;
    int[] result = new int[n];

    Arrays.sort(potions);

    for (int i = 0; i < n; i++) {
      result[i] = m - binarySearch(potions, Math.ceil(success / (double) spells[i]));
    }

    return result;
  }
}
