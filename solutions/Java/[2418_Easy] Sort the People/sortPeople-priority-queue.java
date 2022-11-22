class Solution {
  public String[] sortPeople(String[] names, int[] heights) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    int n = heights.length;

    for (int i = 0; i < n; i++) {
      pq.add(new int[] {i, heights[i]});
    }

    String[] result = new String[n];
    int i = 0;

    while (!pq.isEmpty()) {
      int[] nextTallestIndex = pq.remove();
      result[i] = names[nextTallestIndex[0]];
      i++;
    }

    return result;
  }
}
