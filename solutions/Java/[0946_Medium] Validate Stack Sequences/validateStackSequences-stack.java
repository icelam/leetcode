class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int poppedIndex = 0;

    for (int n: pushed) {
      stack.push(n);

      while (poppedIndex < popped.length && !stack.empty() && stack.peek() == popped[poppedIndex]) {
        stack.pop();
        poppedIndex++;
      }
    }

    return poppedIndex == popped.length;
  }
}
