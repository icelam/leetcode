class Solution {
  public int countSymmetricIntegers(int low, int high) {
    int count = 0;

    // Since it is impossible for numbers with odd number of digits to be symmetric number,
    // possible numbers will only falls within range 11 - 99 and 1000 - 9999.
    // When we are checking numbers in the range 11 - 99, symmetric number will only be multiple of 11.
    // Round the number so that it does not count false positive for test case like low = 12, high = 12
    int middleBoundary = Math.min(99, high) / 11 * 11;

    for (int i = Math.max(11, low); i <= middleBoundary; i += 11) {
      count++;
    }

    if (high >= 1000) {
      for (int i = Math.max(1000, low); i <= Math.min(9999, high); i++) {
        int left = i / 100;
        int right = i % 100;

        if (left / 10 + left % 10 == right / 10 + right % 10) {
          count++;
        }
      }
    }

    return count;
  }
}
