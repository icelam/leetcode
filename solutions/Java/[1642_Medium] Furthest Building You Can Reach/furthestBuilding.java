class Solution {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    for (int i = 1; i < heights.length; i++) {
      int heightDifference = heights[i] - heights[i - 1];

      if (heightDifference > 0) {
        pq.add(heightDifference);
        bricks -= heightDifference;

        if (bricks < 0 && pq.peek() >= heightDifference && ladders > 0) {
          ladders--;
          bricks += pq.poll();
          continue;
        }

        if (bricks < 0) {
          return i - 1;
        }
      }
    }

    return heights.length - 1;
  }
}
