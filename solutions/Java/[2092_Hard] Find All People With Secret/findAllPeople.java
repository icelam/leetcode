class UnionFind {
  private int[] group;
  private int[] rank;

  public UnionFind(int size) {
    group = new int[size];
    rank = new int[size];

    for (int i = 0; i < size; i++) {
      group[i] = i;
    }
  }

  public int find(int vertex) {
    if (group[vertex] != vertex) {
      group[vertex] = find(group[vertex]);
    }

    return group[vertex];
  }

  public boolean union(int vertex1, int vertex2) {
    int group1 = find(vertex1);
    int group2 = find(vertex2);

    if (group1 == group2) {
      return false;
    }

    if (rank[group1] > rank[group2]) {
      group[group2] = group1;
    } else if (rank[group1] < rank[group2]) {
      group[group1] = group2;
    } else {
      group[group1] = group2;
      rank[group2] += 1;
    }

    return true;
  }

  public void reset(int vertex) {
    group[vertex] = vertex;
    rank[vertex] = 0;
  }
}

class Solution {
  public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    int m = meetings.length;

    Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

    UnionFind uf = new UnionFind(n);
    uf.union(0, firstPerson);

    int pointer = 0;
    int currentTime = meetings[0][2];

    while (pointer < m) {
      int start = pointer;

      while (pointer < m && meetings[pointer][2] == currentTime) {
        int personA = meetings[pointer][0];
        int personB = meetings[pointer][1];
        uf.union(personA, personB);
        pointer++;
      }

      if (pointer < m) {
        currentTime = meetings[pointer][2];
      }

      for (int i = start; i < pointer; i++) {
        if (uf.find(meetings[i][0]) != uf.find(0)) {
          uf.reset(meetings[i][0]);
          uf.reset(meetings[i][1]);
        }
      }
    }

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (uf.find(i) == uf.find(0)) {
        result.add(i);
      }
    }

    return result;
  }
}
