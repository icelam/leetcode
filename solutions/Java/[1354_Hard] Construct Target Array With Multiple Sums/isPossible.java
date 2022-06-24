class Solution {
  public boolean isPossible(int[] target) {
    if (target.length == 1) {
      return target[0] == 1;
    }

    int sum = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

    for (int n: target) {
      heap.add(n);
      sum += n;
    }

    while (sum != target.length) {
      int current = heap.poll();

      if (sum - current == 1) {
        return true;
      }

      int previous = current % (sum - current);

      // Two case to consider that the target is impossible to form:
      // 1. A `previous` value that is smaller than 1,
      //    since initial array will have a minimum 1 in all value
      // 2. Previous value == current largest value (previous sum).
      //    Consider [10, 5] which will have `previous (5) == current (5)`
      //    if we do not early exit on the first iteration,
      //    which mich lead to infinity loop
      if (previous >= current || previous < 1) {
        return false;
      }

      sum = sum - (current - previous);
      heap.offer(previous);
    }

    return true;
  }
}
