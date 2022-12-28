class Solution {
  public int minStoneSum(int[] piles, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
    int totalStones = 0;

    for (int stones: piles) {
      heap.add(stones);
      totalStones += stones;
    }

    for (int i = 0; i < k; i++) {
      int largestPile = heap.remove();
      int stonesToRemove = (largestPile / 2);
      heap.add(largestPile - stonesToRemove);
      totalStones -= stonesToRemove;
    }

    return totalStones;
  }
}
