class Solution {
  public int countDays(int days, int[][] meetings) {
    Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    int result = days;
    int min = meetings[0][0];
    int max = meetings[0][1];

    // Merge meeting intervals before calculation
    for (int i = 1; i < meetings.length; i++) {
      if (meetings[i][0] <= max) {
        min = Math.min(min, meetings[i][0]);
        max = Math.max(max, meetings[i][1]);
      } else {
        result -= max - min + 1;
        min = meetings[i][0];
        max = meetings[i][1];
      }
    }

    // Calculate last merged meeting interval
    result -= max - min + 1;
    return result;
  }
}
