class Solution {
  public boolean checkPerfectNumber(int num) {
    if (num <= 1) {
      return false;
    }

    int sumOfDivisors = 1;
    int sqrtNum = (int) Math.sqrt(num);

    for (int i = 2; i <= sqrtNum; i++) {
      if (num % i == 0) {
        sumOfDivisors += i;

        if (num / i != i) {
          sumOfDivisors += num / i;
        }
      }
    }

    return num == sumOfDivisors;
  }
}
