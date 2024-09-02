class Solution {
  public int chalkReplacer(int[] chalk, int k) {
    int n = chalk.length;
    int i = 0;
    long totalChalkUsed = 0;

    for (int currentChalkNeeded: chalk) {
      totalChalkUsed += currentChalkNeeded;
    }

    k %= totalChalkUsed;

    while (k >= chalk[i]) {
      k -= chalk[i];
      i++;
    }

    return i;
  }
}
