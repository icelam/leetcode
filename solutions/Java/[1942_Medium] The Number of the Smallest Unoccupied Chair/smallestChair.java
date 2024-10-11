class Solution {
  public int smallestChair(int[][] times, int targetFriend) {
    int[] targetInfo = times[targetFriend];
    PriorityQueue<Integer> unoccupiedSeats = new PriorityQueue<>();
    PriorityQueue<int[]> occupiedSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    for (int i = 0; i < times.length; i++) {
      unoccupiedSeats.offer(i);
    }

    Arrays.sort(times, (a, b) -> a[0] - b[0]);

    for (int[] time: times) {
      int start = time[0];
      int end = time[1];

      while (!occupiedSeats.isEmpty() && occupiedSeats.peek()[0] <= start) {
        unoccupiedSeats.add(occupiedSeats.remove()[1]);
      }

      int nextSeat = unoccupiedSeats.remove();

      if (Arrays.equals(time, targetInfo)) {
        return nextSeat;
      }

      occupiedSeats.add(new int[]{end, nextSeat});
    }

    return -1;
  }
}

