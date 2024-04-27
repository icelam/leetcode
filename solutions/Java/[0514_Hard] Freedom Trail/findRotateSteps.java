class Solution {
  /**
   * Calculate the minimum steps needed to travel from a to b
   */
  private int calculateMinTravelSteps(int size, int a, int b) {
    int clockwiseSteps = (size + a - b) % size;
    int anticlockwiseSteps = (size + b - a) % size;
    return Math.min(clockwiseSteps, anticlockwiseSteps);
  }

  /**
   * Record the appearance of each character in terms of position (0-indexed).
   * e.g. str = godding, output = {g: [0, 6]}
   */
  private List<Integer>[] generatePositionMap(String str) {
    int n = str.length();
    char[] characters = str.toCharArray();
    List<Integer>[] positions = new ArrayList[26];

    for (int i = 0; i < 26; i++) {
      positions[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < n; i++) {
      positions[characters[i] - 'a'].add(i);
    }

    return positions;
  }

  public int findRotateSteps(String ring, String key) {
    int ringSize = ring.length();
    int keySize = key.length();
    char[] keyChars = key.toCharArray();
    List<Integer>[] positions = generatePositionMap(ring);

    // dp[i][j] = When i-th letter in `key` is matched,
    // minimum number of steps required to use the j-th position in `ring`
    int[][] dp = new int[keySize][ringSize];

    for (int[] row: dp) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    for (int i = 0; i < keySize; i++) {
      for (int j: positions[keyChars[i] - 'a']) {
        // j = position of key[i] in `ring`
        // If it is the first letter (i = 0), no need to consider number of steps taken before,
        // and only calculate the minimum steps needed to travel from 0 to j, and add 1 step for spell.
        if (i == 0) {
          dp[i][j] = Math.min(dp[i][j], calculateMinTravelSteps(ringSize, 0, j) + 1);
          continue;
        }

        // k = position of key[i - 1] (previous letter) in `ring`
        // When it is not the first letter (i > 0), we need to consider number of steps taken before.
        // We need to calculate the minimum steps needed to travel from k to j,
        // and add 1 step for spell on top of dp[i - 1][k], which dp[i - 1][k] = previous minimum steps taken.
        for (int k : positions[keyChars[i - 1] - 'a']) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + calculateMinTravelSteps(ringSize, k, j) + 1);
        }
      }
    }

    int result = Integer.MAX_VALUE;

    for (int steps: dp[keySize - 1]) {
      result = Math.min(result, steps);
    }

    return result;
  }
}
