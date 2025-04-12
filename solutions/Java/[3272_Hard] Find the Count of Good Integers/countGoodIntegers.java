class Solution {
  private int[] calculateFactorial(int n) {
    int[] factorial = new int[n + 1];
    factorial[0] = 1;

    for (int i = 1; i <= n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }

    return factorial;
  }

  public long countGoodIntegers(int n, int k) {
    // pre-calculate factorial used for calculating total
    int[] factorial = calculateFactorial(n);

    long result = 0;
    Set<String> visited = new HashSet<>();
    int base = (int) Math.pow(10, (n - 1) / 2);

    // Enumerate the left half of palindrome number
    for (int i = base; i < base * 10; i++) {
      String s = Integer.toString(i);
      s += new StringBuilder(s).reverse().substring(n % 2);

      // Palindrome number is not divisible by k
      if (Long.parseLong(s) % k > 0) {
        continue;
      }

      char[] sortedS = s.toCharArray();
      Arrays.sort(sortedS);

      // Avoid duplicate count
      if (!visited.add(new String(sortedS))) {
        continue;
      }

      int[] frequency = new int[10];

      for (char c : sortedS) {
        frequency[c - '0']++;
      }

      int total = (n - frequency[0]) * factorial[n - 1];

      for (int count : frequency) {
        total /= factorial[count];
      }

      result += total;
    }

    return result;
  }
}
