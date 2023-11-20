class Solution {
  public int garbageCollection(String[] garbage, int[] travel) {
    int n = garbage.length;
    int[] travelTimeSum = new int[n];
    int[] finishHouse = new int[3];
    int timeNeeded = 0;

    for (int i = 1; i < n; i++) {
      travelTimeSum[i] = travelTimeSum[i - 1] + travel[i - 1];
    }

    for (int i = 0; i < n; i++) {
      char[] garbageTypes = garbage[i].toCharArray();

      for (char type: garbageTypes) {
        int typeIndex = type == 'G' ? 0 : type == 'M' ? 1 : 2;
        timeNeeded++;
        finishHouse[typeIndex] = i;
      }
    }

    for (int i = 0; i < 3; i++) {
      int end = finishHouse[i];
      timeNeeded += travelTimeSum[end];
    }

    return timeNeeded;
  }
}
