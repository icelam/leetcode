class Solution {
  public int maxScore(String s) {
    char[] digits = s.toCharArray();
    int n = s.length();
    int maxScore = 0;
    int leftScore = 0;
    int rightScore = 0;

    for (int i = 0; i < n; i++) {
      rightScore += digits[i] - '0';
    }

    for (int i = 0; i < n - 1; i++) {
      if (digits[i] == '0') {
        leftScore++;
      } else {
        rightScore--;
      }

      maxScore = Math.max(maxScore, leftScore + rightScore);
    }

    return maxScore;
  }
}
