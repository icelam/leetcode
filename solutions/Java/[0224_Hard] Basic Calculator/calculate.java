class Solution {
  private boolean isDigit(char c) {
    return Character.isDigit(c);
  }

  private void calculateLastOperator(Stack<Character> operators, Stack<Integer> numbers) {
    int b = numbers.pop();
    int a = numbers.pop();
    numbers.add(operators.pop() == '+' ? a + b : a - b);
  }

  public int calculate(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    Stack<Character> operators = new Stack<>();
    Stack<Integer> numbers = new Stack<>();
    // To prevent having negative number in the first place
    numbers.add(0);

    int spaceStreak = 0;

    for (int i = 0; i < n; i++) {
      char c = characters[i];

      // Handle spaces
      if (c == ' ') {
        spaceStreak++;
        continue;
      }

      // Handle start of parentheses
      if (c == '(') {
        operators.add(c);
        spaceStreak = 0;
        continue;
      }

      // Handle end of parentheses
      if (c == ')') {
        while (numbers.size() > 1 && !operators.isEmpty()) {
          char currentOperator = operators.peek();

          if (currentOperator == '(') {
            operators.pop();
            break;
          }

          calculateLastOperator(operators, numbers);
        }
        spaceStreak = 0;
        continue;
      }

      // Handle 0 - 9
      if (isDigit(c)) {
        int sum = 0;

        while (i < n && isDigit(characters[i])) {
          sum = sum * 10 + (int) (characters[i] - '0');
          i++;
        }

        i--;
        numbers.add(sum);
        spaceStreak = 0;
        continue;
      }

      // Handle +, - operator
      // When current char is an operator and previous character is start of parentheses,
      // we need to add a leading zero for calculation.
      // Note that '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid)
      // so we will skip handling it
      if (c == '-' && i > 0 && (characters[i - 1 - spaceStreak] == '(')) {
        numbers.add(0);
      }

      // Calculate previous result before adding new one
      // As (2 - 1 + 2) != (2 + 1 - 2), and will cause incorrect result
      // if we stack and calculate them together as stack is LIFO data structure
      while (!operators.isEmpty() && operators.peek() != '(') {
        calculateLastOperator(operators, numbers);
      }

      operators.add(c);
      spaceStreak = 0;
    }

    // Process any remaining operators
    while (numbers.size() > 1 && !operators.isEmpty()) {
      calculateLastOperator(operators, numbers);
    }

    return numbers.peek();
  }
}
