class Solution {
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    int refillCount = 0;

    if (startFuel >= target) {
      return refillCount;
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    int currentDistance = 0;
    int remainingFuel = startFuel;
    int stationIndex = 0;

    while (currentDistance < target) {
      currentDistance += remainingFuel;
      remainingFuel = 0;

      if (currentDistance >= target) {
        break;
      }

      // Positions is strictly increasing according to constraints
      // No need to do sorting
      while (
        stationIndex < stations.length
        && stations[stationIndex][0] <= currentDistance
      ) {
        pq.add(stations[stationIndex]);
        stationIndex++;
      }

      if (pq.isEmpty()) {
        refillCount = -1;
        break;
      }

      int[] stationWithLargestFuel = pq.remove();
      remainingFuel += stationWithLargestFuel[1];
      refillCount++;
    }

    return refillCount;
  }
}
