class MyQueue {
  private Stack<Integer> stack;
  private Stack<Integer> temp;
  int head = -1;

  public MyQueue() {
    stack = new Stack<>();
    temp = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);

    if (head == -1) {
      head = x;
    }
  }

  public int pop() {
    int target = -1;

    while (!stack.empty()) {
      if (stack.size() > 1) {
        temp.push(stack.peek());
      } else {
        target = stack.peek();
      }
      stack.pop();
    }

    head = temp.empty() ? -1 : temp.peek();

    while (!temp.empty()) {
      stack.push(temp.peek());
      temp.pop();
    }

    return target;
  }

  public int peek() {
    return head;
  }

  public boolean empty() {
    return stack.empty();
  }
}
