class Solution {
  public int largestAltitude(int[] gain) {
    int sum = 0;
    int maxAltitude = 0;

    for (int altitude: gain) {
      sum += altitude;
      maxAltitude = Math.max(maxAltitude, sum);
    }

    return maxAltitude;
  }
}
