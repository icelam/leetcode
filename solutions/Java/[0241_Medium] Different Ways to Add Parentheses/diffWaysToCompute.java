class Solution {
  Map<String, List<Integer>> map = new HashMap<>();

  public int parseInt(String str) {
    int result = 0;

    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return -1;
      }

      result *= 10;
      result += str.charAt(i) - '0';
    }

    return result;
  }

  public List<Integer> dfs(String expression) {
    int num = parseInt(expression);

    List<Integer> result = new ArrayList<>();

    if (num >= 0) {
      result.add(num);
      return result;
    }

    if (map.containsKey(expression)) {
      return map.get(expression);
    }

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);

      if (Character.isDigit(c)) {
        continue;
      }

      List<Integer> left = dfs(expression.substring(0, i));
      List<Integer> right = dfs(expression.substring(i + 1));

      int value = 0;
      for (int leftValue : left) {
        for (int rightValue : right) {
          if (c == '+') {
            value = leftValue + rightValue;
          } else if (c == '-') {
            value = leftValue - rightValue;
          } else if (c == '*') {
            value = leftValue * rightValue;
          }

          result.add(value);
        }
      }
    }

    map.put(expression, result);

    return result;
  }

  public List<Integer> diffWaysToCompute(String expression) {
    return dfs(expression);
  }
}
