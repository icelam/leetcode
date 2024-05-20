class Solution {
  public int countTestedDevices(int[] batteryPercentages) {
    int testedDevices = 0;

    for (int phoneBattery: batteryPercentages) {
      if (phoneBattery - testedDevices > 0) {
        testedDevices++;
      }
    }

    return testedDevices;
  }
}
