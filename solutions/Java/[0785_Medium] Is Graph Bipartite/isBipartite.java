enum Group {
  GROUP1, GROUP2;
}

class Solution {
  private Group[] groupMap;
  private boolean isValid;

  public Group getOppositeGroup(Group group) {
    return group == Group.GROUP1 ? Group.GROUP2 : Group.GROUP1;
  }

  public void assignGroup(int vertex, Group group, int[][] graph) {
    groupMap[vertex] = group;
    Group neighborColor = getOppositeGroup(group);

    for (int neighbor: graph[vertex]) {
      if (groupMap[neighbor] == null) {
        assignGroup(neighbor, neighborColor, graph);
      } else if (groupMap[neighbor] != neighborColor) {
        isValid = false;
        return;
      }
    }
  }

  public boolean isBipartite(int[][] graph) {
    groupMap = new Group[graph.length];
    isValid = true;

    for (int i = 0; i < graph.length; i++) {
      if (groupMap[i] == null) {
        assignGroup(i, Group.GROUP1, graph);
      }

      if (!isValid) {
        break;
      }
    }

    return isValid;
  }
}
