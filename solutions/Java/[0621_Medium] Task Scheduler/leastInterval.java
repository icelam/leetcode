class Task implements Comparable<Task> {
  private int id;
  private int remaining;
  private int priority;
  private int cooldown;

  public Task(int id, int remaining, int priority, int cooldown) {
    this.id = id;
    this.remaining = remaining;
    this.priority = priority;
    this.cooldown = cooldown;
  }

  @Override public int compareTo(Task o) {
    if (priority == o.priority) {
      return remaining == o.remaining
        ? id - o.id
        : o.remaining - remaining;
    }

    return priority - o.priority;
  }

  public int getRemaining() {
    return remaining;
  }

  public int getPriority() {
    return priority;
  }

  public void completeSingleTask() {
    remaining--;
    priority += (cooldown + 1);
  }
}

class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] frequency = new int[26];
    int currentTime = 0;
    PriorityQueue<Task> pq = new PriorityQueue<>();

    for (char t: tasks) {
      frequency[t - 'A']++;
    }

    for (int i = 0; i < 26; i++) {
      if (frequency[i] > 0) {
        pq.add(new Task(i, frequency[i], 0, n));
      }
    }

    while (!pq.isEmpty()) {
      if (pq.peek().getPriority() > currentTime) {
        currentTime++;
        continue;
      }

      Task currentTask = pq.remove();
      currentTask.completeSingleTask();

      if (currentTask.getRemaining() > 0) {
        pq.add(currentTask);
      }

      currentTime++;
    }

    return currentTime;
  }
}
