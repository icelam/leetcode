class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int[] getPrimeScore(int maxNum) {
    int[] primeScores = new int[maxNum + 1];

    for (int i = 2; i <= maxNum; i++) {
      if (primeScores[i] == 0) {
        for (int j = i; j <= maxNum; j += i) {
          primeScores[j]++;
        }
      }
    }

    return primeScores;
  }

  public int pow(int x, int y) {
    if (y == 0) {
      return 1;
    }

    if (x == 0) {
      return 0;
    }

    long power = 1;
    long baseNum = x;

    while (y != 0) {
      if (y % 2 != 0) {
        power = power * baseNum % MOD;
      }

      baseNum = baseNum * baseNum % MOD;
      y /= 2;
    }

    return (int) power;
  }

  public int maximumScore(List<Integer> nums, int k) {
    int n = nums.size();
    int maxNum = Collections.max(nums);
    int[] primeScores = getPrimeScore(maxNum);
    int[] left = new int[n];
    int[] right = new int[n];

    Arrays.fill(left, -1);
    Arrays.fill(right, n);

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      int currentScore = primeScores[nums.get(i)];

      while (!stack.isEmpty() && primeScores[nums.get(stack.peek())] < currentScore) {
        right[stack.pop()] = i;
      }

      if (!stack.isEmpty()) {
        left[i] = stack.peek();
      }

      stack.push(i);
    }

    long maxScore = 1;
    int[][] numsIndices = new int[n][2];

    for (int i = 0; i < n; i++) {
      numsIndices[i][0] = nums.get(i);
      numsIndices[i][1] = i;
    }

    Arrays.sort(numsIndices, (a, b) -> b[0] - a[0]);

    for (int i = 0; i < n && k > 0; i++) {
      int num = numsIndices[i][0];
      int index = numsIndices[i][1];
      int operations = (int) Math.min((long) (index - left[index]) * (right[index] - index), k);
      maxScore = maxScore * pow(num, operations) % MOD;
      k -= operations;
    }

    return (int) maxScore;
  }
}
