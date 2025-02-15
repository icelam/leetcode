class Solution {
  private boolean isValid(int square, int num) {
    if (num < 0 || square < num) {
      return false;
    }

    if (square == num) {
      return true;
    }

    return (
      isValid(square / 10, num - (square % 10))
      || isValid(square / 100, num - (square % 100))
      || isValid(square / 1000, num - (square % 1000))
    );
  }

  public int punishmentNumber(int n) {
    int result = 0;

    for (int i = 1; i <= n; i++) {
      int square = i * i;

      if (isValid(square, i)) {
        result += square;
      }
    }

    return result;
  }
}
