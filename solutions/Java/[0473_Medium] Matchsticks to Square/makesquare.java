class Solution {
  private boolean dfs(int[] matchsticks, int target, int side1, int side2, int side3, int side4, int index) {
    if (
      index == matchsticks.length
      && side1 == target
      && side2 == target
      && side3 == target
      && side4 == target
    ) {
      return true;
    }

    if (index == matchsticks.length) {
      return false;
    }

    boolean result = false;

    if (!result && side1 + matchsticks[index] <= target) {
      result |= dfs(matchsticks, target, side1 + matchsticks[index], side2, side3, side4, index + 1);
    }

    if (!result && side2 + matchsticks[index] <= target) {
      result |= dfs(matchsticks, target, side1, side2 + matchsticks[index], side3, side4, index + 1);
    }

    if (!result && side3 + matchsticks[index] <= target) {
      result |= dfs(matchsticks, target, side1, side2, side3 + matchsticks[index], side4, index + 1);
    }

    if (!result && side4 + matchsticks[index] <= target) {
      result |= dfs(matchsticks, target, side1, side2, side3, side4 + matchsticks[index], index + 1);
    }

    return result;
  }

  public boolean makesquare(int[] matchsticks) {
    int sum = 0;

    for (int match: matchsticks) {
      sum += match;
    }

    if (sum % 4 != 0) {
      return false;
    }

    // Sort matches in descending order so that DFS can terminate earlier
    // If not sorted, will result in "Time Limit Exceeded"
    // FIXME: is this sort must?
    int[] sortedMatchsticks = Arrays.stream(matchsticks)
      .boxed()
      .sorted(Comparator.reverseOrder())
      .mapToInt(Integer::intValue)
      .toArray();

    // Try assigning a match to each of the 4 sides
    return dfs(sortedMatchsticks, sum / 4, 0, 0, 0, 0, 0);
  }
}
