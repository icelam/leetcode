class Solution {
  public boolean isThree(int n) {
    // Pair(1, n) is always valid
    int count = 2;

    for (int i = 2; i <= Math.sqrt(n) && count < 3; i++) {
      if (n % i == 0) {
        if (n / i != i) {
          count += 2;
        } else {
          count += 1;
        }
      }
    }

    return count == 3;
  }
}
