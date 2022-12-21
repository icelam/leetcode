enum Group {
  GROUP1, GROUP2;
}

class Solution {
  public Group getOppositeGroup(Group group) {
    return group == Group.GROUP1 ? Group.GROUP2 : Group.GROUP1;
  }

  public boolean assignGroup(int vertex, Group group, HashMap<Integer, List<Integer>> edges, Group[] groupMap) {
    groupMap[vertex] = group;
    Group neighborGroup = getOppositeGroup(group);

    for (int neighbor: edges.get(vertex)) {
      if (groupMap[neighbor] == null) {
        assignGroup(neighbor, neighborGroup, edges, groupMap);
      } else if (groupMap[neighbor] != neighborGroup) {
        return false;
      }
    }

    return true;
  }

  public boolean possibleBipartition(int n, int[][] dislikes) {
    HashMap<Integer, List<Integer>> edges = new HashMap<>();

    for (int[] d: dislikes) {
      edges.putIfAbsent(d[0], new ArrayList<Integer>());
      edges.putIfAbsent(d[1], new ArrayList<Integer>());
      edges.get(d[0]).add(d[1]);
      edges.get(d[1]).add(d[0]);
    }

    Group[] groupMap = new Group[n + 1];

    for (int vertex1: edges.keySet()) {
      if (groupMap[vertex1] == null) {
        boolean isValid = assignGroup(vertex1, Group.GROUP1, edges, groupMap);

        if (!isValid) {
          return false;
        }
      }
    }

    return true;
  }
}
