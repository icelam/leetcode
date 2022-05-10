class Solution {
  public int arithmeticSum(int start, int n) {
    return n * ((start + (start + (n - 1))) / 2);
  }

  public void generate(int k, int n, List<Integer> list, List<List<Integer>> result) {
    if (n == 0 && k == 0) {
      result.add(new ArrayList<>(list));
      return;
    }

    int start = list.size() > 0
      ? list.get(list.size() - 1) + 1
      : 1;

    if (n < 0 || k == 0 || arithmeticSum(start, k) > n) {
      return;
    }

    for (int i = start; i <= Math.min(n, 9); i++) {
      list.add(i);
      generate(k - 1, n - i, list, result);
      list.remove(list.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    generate(k, n, new ArrayList<Integer>(), result);
    return result;
  }
}
