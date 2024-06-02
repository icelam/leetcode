class Solution {
  public int minimumChairs(String s) {
    int waitingCount = 0;
    int chairNeeded = 0;

    for (char action: s.toCharArray()) {
      if (action == 'E') {
        waitingCount++;
        chairNeeded = Math.max(chairNeeded, waitingCount);
      } else {
       waitingCount--;
      }
    }

    return chairNeeded;
  }
}
