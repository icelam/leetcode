class Solution {
  public int minimumRounds(int[] tasks) {
    int length = tasks.length;
    int i = 0;
    int minmumRounds = 0;

    Arrays.sort(tasks);

    while (i < length) {
      int j = i;
      double numberOfTaskWithSameDifficulty = 0;

      while (i < length && tasks[i] == tasks[j]) {
        numberOfTaskWithSameDifficulty++;
        i++;
      }

      if (numberOfTaskWithSameDifficulty == 1) {
        return -1;
      }

      minmumRounds += Math.ceil(numberOfTaskWithSameDifficulty / 3);
    }

    return minmumRounds;
  }
}
