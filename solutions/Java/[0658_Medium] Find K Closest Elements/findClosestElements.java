class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> list = new ArrayList<Integer>();

    for (int n: arr) {
      list.add(n);
    }

    Collections.sort(list, (a, b) -> (
      Math.abs(a - x) != Math.abs(b - x)
        ? Math.abs(a - x) - Math.abs(b - x)
        : a - b
    ));

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      result.add(list.get(i));
    }

    Collections.sort(result);

    return result;
  }
}
