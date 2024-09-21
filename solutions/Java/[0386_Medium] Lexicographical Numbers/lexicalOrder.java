class Solution {
  private void dfs(int max, int num, List<Integer> result) {
    if (num > max) {
      return;
    }

    result.add(num);

    for (int i = 0; i <= 9; i++) {
      int newNum = num * 10 + i;

      if (newNum > max) {
        break;
      }

      dfs(max, newNum, result);
    }
  }

  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();

    for (int i = 1; i <= 9; i++) {
      dfs(n, i, result);
    }

    return result;
  }
}
