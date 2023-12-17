class Solution {
  public int minNumber(int[] nums1, int[] nums2) {
    int[] frequency1 = new int[10];
    int[] frequency2 = new int[10];

    int min1 = 9;
    int min2 = 9;
    int min3 = Integer.MAX_VALUE;

    for (int value: nums1) {
      frequency1[value]++;
      min1 = Math.min(min1, value);
    }

    for (int value: nums2) {
      frequency2[value]++;
      min2 = Math.min(min2, value);

      if (frequency1[value] == 1) {
        min3 = Math.min(min3, value);
      }
    }

    return Math.min(min3, Math.min(min1 * 10 + min2, min2 * 10 + min1));
  }
}
