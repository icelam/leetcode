class Solution {
  public int[] smallestRange(List<List<Integer>> nums) {
    int maxValue = Integer.MIN_VALUE;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    for (int i = 0; i < nums.size(); i++) {
      int value = nums.get(i).get(0);
      pq.add(new int[]{value, i, 0});
      maxValue = Math.max(value, maxValue);
    }

    int range1 = pq.peek()[0];
    int range2 = maxValue;
    int smallestRange = maxValue - range1;

    while (!pq.isEmpty()) {
      int[] current = pq.remove();
      int numArrayIndex = current[1];
      int nextNumIndex = current[2] + 1;
      List<Integer> list = nums.get(numArrayIndex);

      if (list.size() == nextNumIndex) {
        break;
      }

      int value = list.get(nextNumIndex);
      pq.add(new int[]{value, numArrayIndex, nextNumIndex});

      int minValue = pq.peek()[0];
      maxValue = Math.max(value, maxValue);

      if (maxValue - minValue < smallestRange) {
        smallestRange = maxValue - minValue;
        range1 = minValue;
        range2 = maxValue;
      }
    }

    return new int[]{range1, range2};
  }
}
