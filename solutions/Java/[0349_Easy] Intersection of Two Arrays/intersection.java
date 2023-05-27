class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    int[] frequencies1 = new int[1001];
    int[] frequencies2 = new int[1001];

    for (int n: nums1) {
      frequencies1[n]++;
    }

    for (int n: nums2) {
      frequencies2[n]++;
    }

    int[] result = new int[1001];
    int resultIndex = 0;

    for (int i = 0; i < 1001; i++) {
      if (frequencies1[i] > 0 && frequencies2[i] > 0) {
        result[resultIndex] = i;
        resultIndex++;
      }
    }

    return Arrays.copyOf(result, resultIndex);
  }
}
