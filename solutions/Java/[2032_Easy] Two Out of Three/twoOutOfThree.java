class Solution {
  public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
    int[][] frequencies = new int[3][101];

    for (int n: nums1) {
      frequencies[0][n]++;
    }

    for (int n: nums2) {
      frequencies[1][n]++;
    }

    for (int n: nums3) {
      frequencies[2][n]++;
    }

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < 101; i++) {
      int zeroCount = 0;

      for (int j = 0; j < 3; j++) {
        if (frequencies[j][i] == 0) {
          zeroCount++;
        }
      }

      if (zeroCount <= 1) {
        result.add(i);
      }
    }

    return result;
  }
}
