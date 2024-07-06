class Solution {
  public int passThePillow(int n, int time) {
    // For example: n = 4
    // 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1
    // Time needed for 1 passing cycle = 6s => 2 * (n - 1)
    int timeNeededForFullRound = 2 * (n - 1);
    int remainingTime = time % timeNeededForFullRound;

    if (remainingTime < n) {
      return remainingTime + 1;
    }

    // if remainingTime >= n, we will need to reverse passing (decrease index)
    return n - (remainingTime - n) - 1;
  }
}
