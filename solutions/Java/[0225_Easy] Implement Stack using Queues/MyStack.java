class MyStack {
  private Queue<Integer>[] queues;
  private int currentQueue;
  private int lastElement;

  public MyStack() {
    queues = new Queue[]{new LinkedList<Integer>(), new LinkedList<Integer>()};
    currentQueue = 0;
    lastElement = -1;
  }

  public void push(int x) {
    queues[currentQueue].add(x);
    lastElement = x;
  }

  public int pop() {
    int otherQueue = currentQueue == 0 ? 1 : 0;
    int x = -1;

    while (!queues[currentQueue].isEmpty()) {
      x = queues[currentQueue].remove();
      if (queues[currentQueue].size() > 0) {
        queues[otherQueue].add(x);
        lastElement = x;
      } else if (queues[otherQueue].size() == 0) {
        lastElement = -1;
      }
    }

    currentQueue = otherQueue;
    return x;
  }

  public int top() {
    return lastElement;
  }

  public boolean empty() {
    return lastElement == -1;
  }
}
