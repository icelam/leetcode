class Solution {
  private void dfs(int[][] stones, HashSet<Pair<Integer, Integer>> visited, int x, int y) {
    visited.add(new Pair(x, y));

    for (int[] s: stones) {
      if (!visited.contains(new Pair(s[0], s[1]))) {
        if (x == s[0] || y == s[1]) {
          dfs(stones, visited, s[0], s[1]);
        }
      }
    }
  }

  public int removeStones(int[][] stones) {
    HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
    int result = stones.length;

    for (int[] s: stones) {
      if (!visited.contains(new Pair(s[0], s[1]))) {
        dfs(stones, visited, s[0], s[1]);
        result--;
      }
    }

    return result;
  }
}
