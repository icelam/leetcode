class Solution {
  public int arithmeticSums(int n) {
    return (n * (n + 1)) / 2;
  }

  public int candy(int[] ratings) {
    int numberOfChildren = ratings.length;

    if (numberOfChildren < 2) {
      return numberOfChildren;
    }

    int candies = 0;
    int increasingStreak = 0;
    int decreasingStreak = 0;
    int oldDifference = 0;

    for (int i = 1; i < numberOfChildren; i++) {
      int newDifference = ratings[i] - ratings[i - 1];

      if (
        (oldDifference > 0 && newDifference == 0)
        || (oldDifference < 0 && newDifference >= 0)
      ) {
        candies += (
          arithmeticSums(increasingStreak)
          + arithmeticSums(decreasingStreak)
          + Math.max(increasingStreak, decreasingStreak)
        );
        increasingStreak = 0;
        decreasingStreak = 0;
      }

      if (newDifference > 0) {
        increasingStreak++;
      }

      if (newDifference < 0) {
        decreasingStreak++;
      }

      if (newDifference == 0) {
        candies++;
      }

      oldDifference = newDifference;
    }

    candies += (
      arithmeticSums(increasingStreak)
      + arithmeticSums(decreasingStreak)
      + Math.max(increasingStreak, decreasingStreak)
      + 1
    );

    return candies;
  }
}
