class Solution {
  private int arithmeticSums(int n) {
    return (n * (n + 1)) / 2;
  }

  public int differenceOfSums(int n, int m) {
    int sum = arithmeticSums(n);
    int num2 = m * arithmeticSums(n / m);
    int num1 = sum - num2;
    return num1 - num2;
  }
}
