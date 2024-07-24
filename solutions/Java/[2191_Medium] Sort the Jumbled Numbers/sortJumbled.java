class Solution {
  private int mapValue(int n, int[] mapping) {
    int result = 0;
    int place = 1;

    while (n != 0) {
      result += mapping[n % 10] * place;
      n /= 10;
      place *= 10;
    }

    return result;
  }

  public int[] sortJumbled(int[] mapping, int[] nums) {
    int n = nums.length;
    int[][] sortedPairs = new int[n][2];

    for (int i = 0; i < n; i++) {
      sortedPairs[i][0] = i;
      sortedPairs[i][1] = mapValue(nums[i], mapping);
    }

    Arrays.sort(sortedPairs, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      result[i] = nums[sortedPairs[i][0]];
    }

    return result;
  }
}
