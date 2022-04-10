class Solution {
  public int calPoints(String[] ops) {
    int[] records = new int[ops.length];
    int size = 0;
    int sum = 0;

    for (String operation: ops) {
      int score = 0;

      if (operation.equals("+")) {
        score = records[size - 1] + records[size - 2];
        sum += score;
        records[size] = score;
        size++;
      } else if (operation.equals("D")) {
        score = records[size - 1] * 2;
        sum += score;
        records[size] = score;
        size++;
      } else if (operation.equals("C")) {
        sum -= records[size - 1];
        size--;
      } else {
        score = Integer.parseInt(operation);
        sum += score;
        records[size] = score;
        size++;
      }
    }

    return sum;
  }
}
