class Solution {
  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    int m = l.length;
    List<Boolean> result = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      int left = l[i];
      int right = r[i];
      int size = (right - left) + 1;
      int[] tempArr = new int[size];

      for (int j = 0; j < size; j++) {
        tempArr[j] = nums[left + j];
      }

      Arrays.sort(tempArr);

      int step = tempArr[1] - tempArr[0];
      boolean isArithmeticSubarray = true;

      for (int k = 2; k < size; k++) {
        if (tempArr[k] - tempArr[k - 1] != step) {
          isArithmeticSubarray = false;
          break;
        }
      }

      result.add(isArithmeticSubarray);
    }

    return result;
  }
}
