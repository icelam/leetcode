class MinStack {
  public class StackItem {
    private int value;
    private int min;

    public StackItem(int value, int min) {
      this.value = value;
      this.min = min;
    }
  }

  private Stack<StackItem> stack;
  private int min;

  public MinStack() {
    stack = new Stack<StackItem>();
    min = Integer.MAX_VALUE;
  }

  public void push(int val) {
    if (stack.isEmpty() || val <= min) {
      min = val;
    }

    StackItem item = new StackItem(val, min);
    stack.push(item);
  }

  public void pop() {
    StackItem removedItem = stack.pop();

    if (!stack.isEmpty()) {
      StackItem topItem = stack.peek();
      min = topItem.min;
    } else {
      min = Integer.MAX_VALUE;
    }
  }

  public int top() {
    StackItem topItem = stack.peek();
    return topItem.value;
  }

  public int getMin() {
    return min;
  }
}
