class Solution {
  public int alternateDigitSum(int n) {
    Stack<Integer> stack = new Stack<>();

    while (n > 0) {
      stack.push(n % 10);
      n /= 10;
    }

    int sign = 1;
    int sum = 0;

    while (!stack.isEmpty()) {
      sum += stack.pop() * sign;
      sign *= -1;
    }

    return sum;
  }
}
