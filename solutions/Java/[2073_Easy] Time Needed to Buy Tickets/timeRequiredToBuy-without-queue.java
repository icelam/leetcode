class Solution {
  public int timeRequiredToBuy(int[] tickets, int k) {
    int n = tickets.length;
    int timeNeeded = 0;

    for (int i = 0; tickets[k] > 0; i = (i + 1) % n) {
      if (tickets[i] == 0) {
        continue;
      }

      timeNeeded++;
      tickets[i]--;
    }

    return timeNeeded;
  }
}
