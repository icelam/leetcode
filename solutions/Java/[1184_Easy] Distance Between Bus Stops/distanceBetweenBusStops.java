class Solution {
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int n = distance.length;

    if (destination < start) {
      int temp = start;
      start = destination;
      destination = temp;
    }

    int distance1 = 0;
    for (int i = start; i < destination; i++) {
      distance1 += distance[i];
    }

    int distance2 = 0;
    for (int i = destination; i < start + n; i++) {
      distance2 += distance[i % n];
    }

    return Math.min(distance1, distance2);
  }
}
