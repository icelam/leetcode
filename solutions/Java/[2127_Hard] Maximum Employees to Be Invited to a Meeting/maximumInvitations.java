class Solution {
  public int maximumInvitations(int[] favorite) {
    int n = favorite.length;
    int[] degree = new int[n];
    int[] maxDepth = new int[n];
    Queue<Integer> queue = new LinkedList<>();

    for (int person: favorite) {
      degree[person]++;
    }

    for (int i = 0; i < n; i++) {
      if (degree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int x = queue.remove();
      int y = favorite[x];

      maxDepth[y] = maxDepth[x] + 1;
      degree[y]--;

      if (degree[y] == 0) {
        queue.add(y);
      }
    }

    int maxLength = 0;
    int chainLength = 0;

    for (int i = 0; i < n; i++) {
      if (degree[i] == 0) {
        continue;
      }

      degree[i] = 0;
      int ringSize = 1;

      for (int j = favorite[i]; j != i; j = favorite[j]) {
        degree[j] = 0;
        ringSize++;
      }

      if (ringSize == 2) {
        chainLength += maxDepth[i] + maxDepth[favorite[i]] + 2;
      } else {
        maxLength = Math.max(maxLength, ringSize);
      }
    }
    return Math.max(maxLength, chainLength);
  }
}
