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
}

class Solution {
  private List<Integer> getFactors(int n) {
    List<Integer> result = new ArrayList<>();
    double squareRoot = Math.sqrt(n);

    for (int i = 2; i <= squareRoot; i++) {
     if (n % i == 0) {
       result.add(i);
       result.add(n / i);
     }
   }

   return result;
  }

  public boolean canTraverseAllPairs(int[] nums) {
    int n = nums.length;

    if (n <= 1) {
      return true;
    }

    UnionFind uf = new UnionFind(100001);

    for (int value: nums) {
      // If there are multiple numbers and one of them is 1,
      // then there must be a least common multiple of 1 between this number
      // and other numbers, which makes it impossible to traverse
      if (value == 1) {
        return false;
      }

      for (int factor: getFactors(value)) {
        uf.union(factor, value);
      }
    }

    for (int value: nums) {
      if (uf.find(nums[0]) != uf.find(value)) {
        return false;
      }
    }

    return true;
  }
}
