class MyCircularDeque {
  private int[] deque;
  private int start;
  private int end;
  private int size;
  private int capacity;

  public MyCircularDeque(int k) {
    deque = new int[k];
    start = 0;
    end = k - 1;
    size = 0;
    capacity = k;
  }

  public boolean insertFront(int value) {
    if (size >= deque.length) {
      return false;
    }
    start = (start - 1 + capacity) % capacity;
    deque[start] = value;
    size++;
    return true;
  }

  public boolean insertLast(int value) {
    if (size >= deque.length) {
      return false;
    }
    end = (end + 1) % capacity;
    deque[end] = value;
    size++;
    return true;
  }

  public boolean deleteFront() {
    if (size == 0) {
      return false;
    }
    size--;
    start = (start + 1) % capacity;
    return true;
  }

  public boolean deleteLast() {
    if (size == 0) {
      return false;
    }
    size--;
    end = (end - 1 + capacity) % capacity;
    return true;
  }

  public int getFront() {
    if (size == 0) {
      return -1;
    }
    return deque[start];
  }

  public int getRear() {
    if (size == 0) {
      return -1;
    }
    return deque[end];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size >= capacity;
  }
}
