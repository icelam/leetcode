class Solution {
  public int timeRequiredToBuy(int[] tickets, int k) {
    int n = tickets.length;
    int timeNeeded = 0;

    for (int i = 0; i < n; i++) {
      if (i <= k) {
        timeNeeded += Math.min(tickets[k], tickets[i]);
      } else {
        timeNeeded += Math.min(tickets[k] - 1, tickets[i]);
      }
    }

    return timeNeeded;
  }
}
