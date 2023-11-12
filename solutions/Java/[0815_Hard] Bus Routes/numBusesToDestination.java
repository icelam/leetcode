class Solution {
  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }

    int routeCount = routes.length;
    HashMap<Integer, List<Integer>> stopRouteMap = new HashMap<>();

    for (int routeNum = 0; routeNum < routes.length; routeNum++) {
      for (int stop: routes[routeNum]) {
        stopRouteMap.computeIfAbsent(stop, value -> new ArrayList<Integer>()).add(routeNum);
      }
    }

    boolean[] visitedRoutes = new boolean[routeCount];
    HashSet<Integer> visitedStops = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visitedStops.add(source);
    int count = 0;

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      count++;

      for (int i = 0; i < batchSize; i++) {
        int currentStop = queue.remove();

        for (int routeNum: stopRouteMap.get(currentStop)) {
          if (visitedRoutes[routeNum]) {
            continue;
          }

          visitedRoutes[routeNum] = true;

          for (int stop: routes[routeNum]) {
            if (stop == target) {
              return count;
            }

            if (stop == currentStop || visitedStops.contains(stop)) {
              continue;
            }

            queue.add(stop);
            visitedStops.add(stop);
          }
        }
      }
    }

    return -1;
  }
}
