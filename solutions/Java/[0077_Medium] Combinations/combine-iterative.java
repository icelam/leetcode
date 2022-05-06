class Solution {
  public List<List<Integer>> combine(int n, int k) {
    LinkedList<List<Integer>> result = new LinkedList<>();

    for (int i = 1; i <= n - (k - 1); i++) {
      List<Integer> item = new ArrayList<>();
      item.add(i);
      result.add(item);
    }

    while (result.size() > 0 && result.get(0).size() < k) {
      List<Integer> item = result.removeFirst();
      int length = item.size();

      for (int i = item.get(length - 1) + 1; i <= n - (k - (length + 1)); i++) {
        List<Integer> newItem = new ArrayList<>(item);
        newItem.add(i);
        result.add(newItem);
      }
    }

    return result;
  }
}
