class Solution {
  public int countLargestGroup(int n) {
    int MAX_DIGIT_SUM = 36;
    int[] groupSize = new int[MAX_DIGIT_SUM + 1];

    for (int i = 1; i <= n; i++) {
      int num = i;
      int sum = 0;

      while (num > 0) {
        sum += num % 10;
        num /= 10;
      }

      groupSize[sum]++;
    }

    Arrays.sort(groupSize);

    int largestGroupSize = groupSize[MAX_DIGIT_SUM];
    int largestGroupCount = 0;

    for (int i = MAX_DIGIT_SUM; i >= 0; i--) {
      if (groupSize[i] != largestGroupSize) {
        break;
      }

      largestGroupCount++;
    }

    return largestGroupCount;
  }
}
