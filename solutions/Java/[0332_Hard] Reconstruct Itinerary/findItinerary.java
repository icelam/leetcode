class Solution {
  private List<String> result;
  private Map<String, PriorityQueue<String>> graph;

  private void dfs(String source) {
    PriorityQueue<String> neighbor = graph.get(source);

    while (neighbor != null && neighbor.size() > 0) {
      String destination = neighbor.poll();
      dfs(destination);
    }

    result.add(0, source);
  }

  public List<String> findItinerary(List<List<String>> tickets) {
    // Use Hierholzer's Algorithm to find Eulerian path
    result = new LinkedList<>();
    graph = new HashMap<>();

    for (List<String> ticket : tickets) {
      PriorityQueue<String> neighbor = graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
      neighbor.add(ticket.get(1));
    }

    // `tickets` is never an empty list, skip checking existance of "JKF"
    dfs("JFK");
    return result;
  }
}
