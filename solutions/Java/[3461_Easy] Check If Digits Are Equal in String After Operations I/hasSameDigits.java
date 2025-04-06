class Solution {
  public boolean hasSameDigits(String s) {
    Queue<Integer> queue = new LinkedList<>();

    for (char c : s.toCharArray()) {
      queue.add(c - '0');
    }

    while (queue.size() > 2) {
      int n = queue.size() - 1;

      for (int i = 0; i < n; i++) {
        queue.add((queue.remove() + queue.peek()) % 10);
      }

      queue.remove();
    }

    return Objects.equals(queue.remove(), queue.peek());
  }
}
