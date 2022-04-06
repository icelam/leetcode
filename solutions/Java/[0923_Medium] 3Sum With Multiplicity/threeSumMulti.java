class Solution {
  public static int ncr(int n, int r) {
    int mod = 1000000007;

    if (r > n - r) {
      r = n - r;
    }

    int[] C = new int[r + 1];

    C[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = Math.min(i, r); j > 0; j--) {
        C[j] = (C[j] + C[j - 1]) % mod;
      }
    }
    return C[r];
  }

  public int threeSumMulti(int[] arr, int target) {
    int[] count = new int[101];
    List<Integer> nums = new ArrayList<>();
    int result = 0;

    for (int i = 0; i < arr.length; i++) {
      if (count[arr[i]] == 0) {
        nums.add(arr[i]);
      }

      count[arr[i]]++;
    }

    Collections.sort(nums);

    // Calculate nCr of matched tuples, 4 scenario to handle:
    // - i < j < k
    // - i == j == k
    // - i == j
    // - j == l
    // For sorted array, i == k should already be covered by i == j == k
    for (int i = 0; i < nums.size(); i++) {
      int num1 = nums.get(i);
      for (int j = i; j < nums.size(); j++) {
        int num2 = nums.get(j);
        int num3 = target - nums.get(j) - nums.get(i);

        // num3 is invalid since 0 <= arr[i] <= 100
        if (num3 < 0 || num3 > 100) {
          continue;
        }

        // To make sure tuples are unique, we need to check if
        // nums in the current tuples are in ascending order or not.
        // Also it is possible that num1 == num2, but since we have
        // dedup the nums to reduces the number of times we need to loop,
        // we need to check num1 has a count >= 2.
        if (
          count[num3] > 0
          && num3 >= num2 && num2 >= num1
          && (num1 == num2 && count[num1] >= 2 || num1 != num2)
        ) {
          if (num3 > num2 && num2 > num1) {
            result += ncr(count[num1], 1) * ncr(count[num2], 1) * ncr(count[num3], 1);
          } else if (num1 == num2 && num2 == num3 && count[num1] >= 3) {
            result += ncr(count[num1], 3);
          } else if (num1 == num2 && num2 != num3) {
            result += ncr(count[num1], 2) * ncr(count[num3], 1);
          } else if (num2 == num3 && num1 != num2 && count[num2] >= 2) {
            result += ncr(count[num1], 1) * ncr(count[num2], 2);
          }
        }
      }
    }

    return result;
  }
}
