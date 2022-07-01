class Solution {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

    int maxUnits = 0;

    for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
      int boxToTake = Math.min(truckSize, boxTypes[i][0]);
      maxUnits += boxToTake * boxTypes[i][1];
      truckSize -= boxToTake;
    }

    return maxUnits;
  }
}
