class Solution {
  public int xorAllNums(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int xor1 = 0;
    int xor2 = 0;

    for (int i = 0; n % 2 != 0 && i < m; i++) {
      xor1 ^= nums1[i];
    }

    for (int i = 0; m % 2 != 0 && i < n; i++) {
      xor2 ^= nums2[i];
    }

    return xor1 ^ xor2;
  }
}
