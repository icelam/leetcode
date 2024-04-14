class RecentCounter {
  private Queue<Integer> logs;

  public RecentCounter() {
    logs = new LinkedList<Integer>();
  }

  public int ping(int t) {
    logs.add(t);

    while (!logs.isEmpty() && logs.peek() < t - 3000) {
      logs.remove();
    }

    return logs.size();
  }
}
