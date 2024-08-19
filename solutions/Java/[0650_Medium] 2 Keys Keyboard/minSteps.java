class Solution {
  public int minSteps(int n) {
    int result = 0;

    for (int divisor = 2; n > 1; divisor++) {
      while (n % divisor == 0) {
        result += divisor;
        n /= divisor;
      }
    }

    return result;
  }
}
