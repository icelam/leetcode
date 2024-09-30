class CustomStack {
  private int[] stack;
  private int capacity;
  private int size;

  public CustomStack(int maxSize) {
    this.stack = new int[maxSize];
    this.capacity = maxSize;
    this.size = 0;
  }

  public void push(int x) {
    if (size == capacity) {
      return;
    }

    stack[size] = x;
    size++;
  }

  public int pop() {
    if (size == 0) {
      return -1;
    }

    size--;
    return stack[size];
  }

  public void increment(int k, int val) {
    k = Math.min(k, size);
    for (int i = 0; i < k; i++) {
      stack[i] += val;
    }
  }
}
