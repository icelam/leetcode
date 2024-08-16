class Solution {
  public int maxDistance(List<List<Integer>> arrays) {
    int result = 0;
    int m = arrays.size();
    int minValue = arrays.get(0).get(0);
    int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);

    for (int i = 1; i < m; i++) {
      int n = arrays.get(i).size();
      int currentMax = Math.max(
        Math.abs(arrays.get(i).get(n - 1) - minValue),
        Math.abs(maxValue - arrays.get(i).get(0))
      );
      result = Math.max(result, currentMax);
      minValue = Math.min(minValue, arrays.get(i).get(0));
      maxValue = Math.max(maxValue, arrays.get(i).get(n - 1));
    }

    return result;
  }
}
