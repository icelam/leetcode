class Solution {
  public int findSpecialInteger(int[] arr) {
    int n = arr.length;
    double m = (double) n / 4;
    int previous = arr[0];
    int streak = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] != previous) {
        previous = arr[i];
        streak = 0;
      }

      streak++;

      if (streak > m) {
        break;
      }
    }

    return previous;
  }
}
