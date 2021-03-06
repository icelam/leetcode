class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> count = new HashMap<>();
    for (int n: nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<Integer> heap = new PriorityQueue((a, b) -> count.get(b) - count.get(a));
    for (int n: count.keySet()) {
      heap.add(n);
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = heap.remove();
    }

    return result;
  }
}
