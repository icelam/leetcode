class MyCircularQueue {
  private int[] deque;
  private int start;
  private int size;
  private int capacity;

  public MyCircularQueue(int k) {
    deque = new int[k];
    start = 0;
    size = 0;
    capacity = k;
  }

  public boolean enQueue(int value) {
    if (size >= deque.length) {
      return false;
    }

    int end = (start + size) % capacity;
    deque[end] = value;
    size++;
    return true;
  }

  public boolean deQueue() {
    if (size == 0) {
      return false;
    }

    size--;
    start = (start + 1) % capacity;
    return true;
  }

  public int Front() {
    if (size == 0) {
      return -1;
    }

    return deque[start];
  }

  public int Rear() {
    if (size == 0) {
      return -1;
    }

    int end = (start + size - 1) % capacity;
    return deque[end];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size >= capacity;
  }
}
