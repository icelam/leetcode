class Solution {
  public static int[] sieveOfEratosthenes(int left, int right) {
    boolean[] isPrime = new boolean[right + 1];
    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;

    for (int p = 2; p * p <= right; p++) {
      if (isPrime[p]) {
        for (int multiple = p * p; multiple <= right; multiple += p) {
          isPrime[multiple] = false;
        }
      }
    }

    int count = 0;

    for (int i = left; i <= right; i++) {
      if (isPrime[i]) {
        count++;
      }
    }

    int[] primes = new int[count];

    for (int i = right; i >= left; i--) {
      if (isPrime[i]) {
        count--;
        primes[count] = i;
      }
    }

    return primes;
  }

  public int[] closestPrimes(int left, int right) {
    int[] primes = sieveOfEratosthenes(left, right);
    int p = -1;
    int q = -1;
    int minDifference = Integer.MAX_VALUE;

    for (int i = 1; i < primes.length; i++) {
      int difference = primes[i] - primes[i - 1];

      if (difference < minDifference) {
        minDifference = difference;
        p = primes[i - 1];
        q = primes[i];
      }
    }

    return new int[]{p, q};
  }
}
