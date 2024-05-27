class Solution {
  public int specialArray(int[] nums) {
    int n = nums.length;
    int[] frequency = new int[1001];
    int maxNum = 0;

    for (int num: nums) {
      frequency[num]++;

      if (num > maxNum) {
        maxNum = num;
      }
    }

    int largerThanNumCount = 0;

    for (int i = maxNum; i >= 0; i--) {
      largerThanNumCount += frequency[i];

      if (i == largerThanNumCount) {
        return i;
      }
    }

    return -1;
  }
}
