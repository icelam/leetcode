class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int sumOfRemainingGas = 0;
    int currentRemainingGas = 0;
    int start = 0;
    int numberOfStations = gas.length;

    for (int i = 0; i < numberOfStations; i++) {
      int remainingGasAtCurrentStation = gas[i] - cost[i];
      currentRemainingGas += remainingGasAtCurrentStation;
      sumOfRemainingGas += remainingGasAtCurrentStation;

      if (currentRemainingGas < 0) {
        start = i + 1;
        currentRemainingGas = 0;
      }
    }

    return sumOfRemainingGas < 0 ? -1 : start;
  }
}
