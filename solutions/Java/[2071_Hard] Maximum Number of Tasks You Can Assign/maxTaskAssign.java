class Solution {
  private boolean check(int[] tasks, int[] workers, int pills, int strength, int k) {
    Deque<Integer> validTasks = new ArrayDeque<>();
    int i = 0;

    for (int j = workers.length - k; j < workers.length; j++) {
      int currentWorker = workers[j];

      while (i < k && tasks[i] <= currentWorker + strength) {
        validTasks.addLast(tasks[i]);
        i++;
      }

      if (validTasks.isEmpty()) {
        return false;
      }

      if (currentWorker >= validTasks.peekFirst()) {
        validTasks.pollFirst();
        continue;
      }

      if (pills == 0) {
        return false;
      }

      pills--;
      validTasks.pollLast();
    }

    return true;
  }

  public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
    Arrays.sort(tasks);
    Arrays.sort(workers);

    int left = 0;
    int right = Math.min(tasks.length, workers.length) + 1;

    while (left + 1 < right) {
      int middle = left + (right - left) / 2;

      if (check(tasks, workers, pills, strength, middle)) {
        left = middle;
      } else {
        right = middle;
      }
    }

    return left;
  }
}
