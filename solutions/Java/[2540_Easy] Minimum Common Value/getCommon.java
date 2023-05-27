class Solution {
  public int getCommon(int[] nums1, int[] nums2) {
    int pointer1 = 0;
    int pointer2 = 0;

    while (nums1[pointer1] != nums2[pointer2]) {
      while (nums1[pointer1] < nums2[pointer2] && pointer1 < nums1.length - 1) {
        pointer1++;
      }

      while (nums1[pointer1] > nums2[pointer2] && pointer2 < nums2.length - 1) {
        pointer2++;
      }

      if (pointer1 == nums1.length - 1 || pointer2 == nums2.length - 1) {
        break;
      }
    }

    if (nums1[pointer1] != nums2[pointer2]) {
      return -1;
    }

    return nums1[pointer1];
  }
}
