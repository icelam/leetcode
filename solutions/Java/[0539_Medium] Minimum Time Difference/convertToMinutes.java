class Solution {
  private int convertToMinutes(String time) {
    return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
  }

  public int findMinDifference(List<String> timePoints) {
    int n = timePoints.size();
    int[] minutes = new int[n];

    for (int i = 0; i < minutes.length; i++) {
      String time = timePoints.get(i);
      minutes[i] = convertToMinutes(time);
    }

    Arrays.sort(minutes);

    int minDiff = Integer.MAX_VALUE;

    for (int i = 0; i < n - 1; i++) {
      minDiff = Math.min(minDiff, minutes[i + 1] - minutes[i]);
    }

    minDiff = Math.min(minDiff, minutes[0] + (24 * 60 - minutes[n - 1]));

    return minDiff;
  }
}
