class Solution {
  public long pickGifts(int[] gifts, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    for (int count: gifts) {
      pq.add(count);
    }

    for (int i = 0; i < k; i++) {
      int maxPile = pq.remove();
      pq.add((int) Math.sqrt(maxPile));
    }

    long remaining = 0;

    while (!pq.isEmpty()) {
      remaining += pq.remove();
    }

    return remaining;
  }
}
