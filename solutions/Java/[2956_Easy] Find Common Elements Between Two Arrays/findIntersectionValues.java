class Solution {
  public int[] findIntersectionValues(int[] nums1, int[] nums2) {
    int[] frequencies1 = new int[101];
    int[] frequencies2 = new int[101];

    for (int n: nums1) {
      frequencies1[n]++;
    }

    for (int n: nums2) {
      frequencies2[n]++;
    }

    int[] result = new int[2];

    for (int i = 1; i < 101; i++) {
      if (frequencies1[i] > 0 && frequencies2[i] > 0) {
        result[0] += frequencies1[i];
        result[1] += frequencies2[i];
      }
    }

    return result;
  }
}
