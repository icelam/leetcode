class Solution {
  public int arithmeticSums(int n) {
    return (n * (n + 1)) / 2;
  }

  public int totalMoney(int n) {
    int weeks = n / 7;
    int remainingDays = n % 7;
    int fullWeekSavings = arithmeticSums(7) * weeks + 7 * arithmeticSums(weeks - 1);
    int remainingDaysSavings = arithmeticSums(remainingDays) + remainingDays * weeks;
    return fullWeekSavings + remainingDaysSavings;
  }
}
