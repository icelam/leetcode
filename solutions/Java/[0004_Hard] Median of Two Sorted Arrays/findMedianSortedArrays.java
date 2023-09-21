class Solution {
  private int getKthElement(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
    int length1 = end1 - start1 + 1;
    int length2 = end2 - start2 + 1;

    // Swap nums1 and nums2 if nums1 has more element compared to nums2
    // This will ensure when one of the array is empty, it will always be nums1
    if (length1 > length2) {
      return getKthElement(nums2, start2, end2, nums1, start1, end1, k);
    }

    // We already swap and make sure nums1 will always be the one with lesser number of elements.
    // Now, we can check if nums1 is empty or not. If it is empty, median will always be (start2 + k - 1).
    if (length1 == 0) {
      return nums2[start2 + k - 1];
    }

    // If k = 1, it indicates that it is closest to the median.
    // That is, whichever value is smaller at the start index of the two arrays will be the median.
    if (k == 1) {
      return Math.min(nums1[start1], nums2[start2]);
    }

    // Prevent array length from being less than k/2, which leads to index out of bound.
    int i = start1 + Math.min(length1, k / 2) - 1;
    int j = start2 + Math.min(length2, k / 2) - 1;

    // Eliminates numbers that is smaller from next search as they won't be k-th smallest element.
    // We will then search for the next (k - eliminated element length)-th smallest element,
    // as the eliminated elements are always the smallest numbers.
    if (nums1[i] > nums2[j]) {
      return getKthElement(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
    } else {
      return getKthElement(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    // Finding median in sorted array actually means to find the k-th smallest number.
    // For median in odd length array, it actually means adding the two numbers in the middle.
    // Here we handles array length of odd and even together.
    // +1 here since the array is 0-indexed, but k-th element is 1-indexed.
    int k1 = (n + m + 1) / 2;
    int k2 = (n + m + 2) / 2;
    return (getKthElement(nums1, 0, n - 1, nums2, 0, m - 1, k1) + getKthElement(nums1, 0, n - 1, nums2, 0, m - 1, k2)) * 0.5;
  }
}
