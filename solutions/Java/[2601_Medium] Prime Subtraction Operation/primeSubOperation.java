class Solution {
  public boolean primeSubOperation(int[] nums) {
    int maxNum = Integer.MIN_VALUE;

    for (int num : nums) {
      maxNum = Math.max(maxNum, num);
    }


    boolean[] isPrime = new boolean[maxNum + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i * i <= maxNum; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= maxNum; j += i) {
          isPrime[j] = false;
        }
      }
    }

    int previousNum = 0;

    for (int num : nums) {
      int boundary = num - (previousNum + 1);
      int maxPrime = 0;

      for (int i = boundary; i > 0; i--) {
        if (isPrime[i]) {
          maxPrime = i;
          break;
        }
      }

      int newNum = num - maxPrime;

      if (newNum <= previousNum) {
        return false;
      }

      previousNum = newNum;
    }

    return true;
  }
}
