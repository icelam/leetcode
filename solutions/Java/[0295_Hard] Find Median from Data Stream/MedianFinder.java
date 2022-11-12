class MedianFinder {
  private PriorityQueue<Integer> priorityQueueMin;
  private PriorityQueue<Integer> priorityQueueMax;

  public MedianFinder() {
    priorityQueueMin = new PriorityQueue<Integer>((a, b) -> (b - a));
    priorityQueueMax = new PriorityQueue<Integer>((a, b) -> (a - b));
  }

  public void addNum(int num) {
    if (priorityQueueMin.isEmpty() || num <= priorityQueueMin.peek()) {
      priorityQueueMin.add(num);
      if (priorityQueueMax.size() + 1 < priorityQueueMin.size()) {
        priorityQueueMax.offer(priorityQueueMin.remove());
      }
    } else {
      priorityQueueMax.add(num);
      if (priorityQueueMax.size() > priorityQueueMin.size()) {
        priorityQueueMin.add(priorityQueueMax.remove());
      }
    }
  }

  public double findMedian() {
    if (priorityQueueMin.size() > priorityQueueMax.size()) {
      return priorityQueueMin.peek();
    }
    return (priorityQueueMin.peek() + priorityQueueMax.peek()) / 2.0;
  }
}
