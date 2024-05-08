class Solution {
  public int addedInteger(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int result = 0;

    for (int i = 0; i < n; i++) {
      result += nums2[i] - nums1[i];
    }

    return result / n;
  }
}
