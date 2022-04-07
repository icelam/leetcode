class Solution {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

    for (int s: stones) {
      priorityQueue.add(s);
    }

    while (priorityQueue.size() > 1) {
      int s1 = priorityQueue.remove();
      int s2 = priorityQueue.remove();

      if (s1 - s2 > 0) {
        priorityQueue.add(s1 - s2);
      }
    }

    return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
  }
}
