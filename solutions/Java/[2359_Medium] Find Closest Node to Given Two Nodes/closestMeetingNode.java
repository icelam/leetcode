class Solution {
  public int[] getDistancesFromNode(int node, int[] edges) {
    int[] distances = new int[edges.length];
    Arrays.fill(distances, -1);
    distances[node] = 0;

    int previousNode = node;
    while (edges[previousNode] != -1) {
      int currentNode = edges[previousNode];

      if (distances[currentNode] != -1) {
        break;
      }

      distances[currentNode] = distances[previousNode] + 1;
      previousNode = currentNode;
    }

    return distances;
  }

  public int closestMeetingNode(int[] edges, int node1, int node2) {
    int[] distanceFromNode1 = getDistancesFromNode(node1, edges);
    int[] distanceFromNode2 = getDistancesFromNode(node2, edges);

    int result = -1;
    int minDistance = Integer.MAX_VALUE;
    for (int n = 0; n < edges.length; n++) {
      if (distanceFromNode1[n] == -1 || distanceFromNode2[n] == -1) {
        continue;
      }

      int currentMinDistance = Math.max(distanceFromNode1[n], distanceFromNode2[n]);
      if (currentMinDistance < minDistance) {
        result = n;
        minDistance = currentMinDistance;
      }
    }

    return result;
  }
}
