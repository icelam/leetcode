class Solution {
  public int numberOfPairs(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;
    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (nums1[i] % (nums2[j] * k) == 0) {
          count++;
        }
      }
    }

    return count;
  }
}
