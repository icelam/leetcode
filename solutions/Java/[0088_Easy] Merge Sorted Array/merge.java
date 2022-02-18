class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }

    for (int i = 0; i < n; i++) {
      nums1[m + i] = nums2[i];
    }

    if (m == 0) {
      return;
    }

    for (int i = nums1.length - 1; i >= 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums1[j] > nums1[i]) {
          int temp = nums1[i];
          nums1[i] = nums1[j];
          nums1[j] = temp;
        }
      }
    }
  }
}
