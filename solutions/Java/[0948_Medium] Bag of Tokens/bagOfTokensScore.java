class Solution {
  public int bagOfTokensScore(int[] tokens, int power) {
    int length = tokens.length;
    int score = 0;
    int maxScore = 0;

    int start = 0;
    int end = length - 1;

    Arrays.sort(tokens);

    // Lose token power and +1 score: power >= token
    // Gain token power and -1 score: score > 0
    while (start <= end && (power >= tokens[start] || score > 0)) {
      while (start <= end && power >= tokens[start]) {
        power -= tokens[start];
        score++;
        start++;
      }

      maxScore = Math.max(maxScore, score);

      if (start <= end && score > 0) {
        power += tokens[end];
        score--;
        end--;
      }
    }

    return maxScore;
  }
}
