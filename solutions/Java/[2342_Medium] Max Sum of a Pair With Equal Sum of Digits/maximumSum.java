import java.util.Arrays;

class Solution {
  private static int getSumOfDigits(int num) {
    int sum = 0;

    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }

    return sum;
  }

  public int maximumSum(int[] nums) {
    // MAX Sum of digit for 1 <= nums[i] <= 10^9 is 81
    int MAX_DIGIT_SUM = 82;

    Integer[][] maxNumsBySumOfDigits = new Integer[MAX_DIGIT_SUM][2];

    for (int num : nums) {
      int sumOfDigits = getSumOfDigits(num);

      if (maxNumsBySumOfDigits[sumOfDigits][0] == null || num > maxNumsBySumOfDigits[sumOfDigits][0]) {
        maxNumsBySumOfDigits[sumOfDigits][1] = maxNumsBySumOfDigits[sumOfDigits][0];
        maxNumsBySumOfDigits[sumOfDigits][0] = num;
      } else if (maxNumsBySumOfDigits[sumOfDigits][1] == null || num > maxNumsBySumOfDigits[sumOfDigits][1]) {
        maxNumsBySumOfDigits[sumOfDigits][1] = num;
      }
    }

    int maxSum = -1;

    for (int i = 0; i < MAX_DIGIT_SUM; i++) {
      if (maxNumsBySumOfDigits[i][0] == null || maxNumsBySumOfDigits[i][1] == null) {
        continue;
      }

      maxSum = Math.max(maxSum, maxNumsBySumOfDigits[i][0] + maxNumsBySumOfDigits[i][1]);
    }

    return maxSum;
  }
}
