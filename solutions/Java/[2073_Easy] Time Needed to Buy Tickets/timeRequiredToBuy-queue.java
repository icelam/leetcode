class Solution {
  public int timeRequiredToBuy(int[] tickets, int k) {
    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

    for (int i = 0; i < tickets.length; i++) {
      queue.add(new Pair(i, tickets[i]));
    }

    int timeNeeded = 0;

    while (!queue.isEmpty()) {
      Pair<Integer, Integer> currentPeople = queue.remove();
      int peopleId = currentPeople.getKey();
      int ticketsToBuy = currentPeople.getValue();

      timeNeeded++;
      ticketsToBuy--;

      if (ticketsToBuy > 0) {
        queue.add(new Pair<Integer, Integer>(peopleId, ticketsToBuy));
        continue;
      }

      if (peopleId == k) {
        break;
      }
    }

    return timeNeeded;
  }
}
