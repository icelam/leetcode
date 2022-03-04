class Solution {
  public double champagneTower(int poured, int queryRow, int queryGlass) {
    if (poured == 0) {
      return 0;
    }

    ArrayList<Double> previousRow = new ArrayList<>();
    previousRow.add((double) poured);

    for (int i = 1; i <= queryRow; i++) {
      ArrayList<Double> currentRow = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        double left = j == 0
          ? 0
          : (previousRow.get(j - 1) - 1) / 2;
        double right = j == i
          ? 0
          : (previousRow.get(j) - 1) / 2;

        currentRow.add(Math.max(0, left) + Math.max(0, right));

        if (i == queryRow && j == queryGlass) {
            break;
        }
      }

      previousRow = currentRow;
    }

    return Math.min(1, previousRow.get(queryGlass));
  }
}
