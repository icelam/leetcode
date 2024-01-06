class Solution {
  private int calculateScore(int[] scores) {
    int totalScore = 0;
    int doubleScore = 0;

    for (int s: scores) {
      if (doubleScore > 0) {
        totalScore += s * 2;
        doubleScore--;
      } else {
        totalScore += s;
      }

      if (s == 10) {
        doubleScore = 2;
      }
    }

    return totalScore;
  }

  public int isWinner(int[] player1, int[] player2) {
    int score1 = calculateScore(player1);
    int score2 = calculateScore(player2);

    if (score1 == score2) {
      return 0;
    }

    if (score1 > score2) {
      return 1;
    }

    return 2;
  }
}
