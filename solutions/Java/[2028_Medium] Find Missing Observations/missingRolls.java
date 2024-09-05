class Solution {
  public int[] missingRolls(int[] rolls, int mean, int n) {
    int m = rolls.length;
    int target = mean * (m + n);
    int currentSum = 0;

    for (int value: rolls) {
      currentSum += value;
    }

    int missingSum = target - currentSum;

    if (missingSum > 6 * n || missingSum < n) {
      return new int[0];
    }

    int missingMean = missingSum / n;
    int reminder = missingSum % n;

    int[] result = new int[n];
    Arrays.fill(result, missingMean);

    for (int i = 0; i < reminder; i++) {
      result[i]++;
    }

    return result;
  }
}
