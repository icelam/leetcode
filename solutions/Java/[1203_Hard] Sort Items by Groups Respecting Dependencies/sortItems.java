class Solution {
  private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
    List<Integer> visited = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    for (Integer vertex: graph.keySet()) {
      if (indegree[vertex] == 0) {
        stack.add(vertex);
      }
    }

    while (!stack.isEmpty()) {
      Integer currentVertex = stack.pop();
      visited.add(currentVertex);

      for (Integer neighbor: graph.get(currentVertex)) {
        indegree[neighbor]--;

        if (indegree[neighbor] == 0) {
          stack.add(neighbor);
        }
      }
    }

    if (visited.size() == graph.size()) {
      return visited;
    }

    return new ArrayList<>();
  }

  public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
    HashMap<Integer, List<Integer>> groupGraph = new HashMap<>();
    Map<Integer, List<Integer>> itemGraph = new HashMap<>();
    int newGroupId = m;

    for (int i = 0; i < n; i++) {
      itemGraph.put(i, new ArrayList<Integer>());

      if (group[i] == -1) {
        group[i] = newGroupId;
        newGroupId++;
      }

      groupGraph.putIfAbsent(group[i], new ArrayList<>());
    }

    int[] itemIndegree = new int[n];
    int[] groupIndegree = new int[newGroupId];

    for (int currentItem = 0; currentItem < n; currentItem++) {
      for (int previousItem: beforeItems.get(currentItem)) {
        itemGraph.get(previousItem).add(currentItem);
        itemIndegree[currentItem]++;

        if (group[currentItem] != group[previousItem]) {
          groupGraph.get(group[previousItem]).add(group[currentItem]);
          groupIndegree[group[currentItem]]++;
        }
      }
    }

    List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
    List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);

    if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
      return new int[0];
    }

    Map<Integer, List<Integer>> orderedGroups = new HashMap<>();

    for (Integer item: itemOrder) {
      orderedGroups.computeIfAbsent(group[item], value -> new ArrayList<>()).add(item);
    }

    int[] result = new int[n];
    int index = 0;

    for (int groupIndex: groupOrder) {
      for (int item: orderedGroups.get(groupIndex)) {
        result[index++] = item;
      }
    }

    return result;
  }
}
