class Solution {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
    List<Integer> boundaries = new ArrayList<Integer>();

    for (int[] b: buildings) {
      boundaries.add(b[0]);
      boundaries.add(b[1]);
    }

    Collections.sort(boundaries);

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    int length = buildings.length;
    int index = 0;

    for (int boundary : boundaries) {
      while (index < length && buildings[index][0] <= boundary) {
        heap.add(new int[]{buildings[index][1], buildings[index][2]});
        index++;
      }

      while (!heap.isEmpty() && heap.peek()[0] <= boundary) {
        heap.remove();
      }

      int max = heap.isEmpty() ? 0 : heap.peek()[1];

      if (result.size() == 0 || max != result.get(result.size() - 1).get(1)) {
        result.add(Arrays.asList(boundary, max));
      }
    }

    return result;
  }
}
