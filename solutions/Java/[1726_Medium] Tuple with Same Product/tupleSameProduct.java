class Solution {
  public int tupleSameProduct(int[] nums) {
    int n = nums.length;
    HashMap<Integer, Integer> frequency = new HashMap<>();

    // Calculate the number of pairs for each product
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int product = nums[i] * nums[j];
        frequency.put(product, frequency.getOrDefault(product, 0) + 1);
      }
    }

    int result = 0;

    for (Integer count: frequency.values()) {
      // If count is 1, which means we only have one `ab` pair found, and cannot form `(a, b, c, d)` where `a * b = c * d`
      if (count == 1) {
        continue;
      }

      // Pick 2 pairs from N count -> use nCr where n = count, r = 2
      // nC2 can be further simplified to sum of naturals formulas, which is (n * (n - 1)) / 2
      // https://math.stackexchange.com/questions/4355305/why-is-nc2-the-sum-of-naturals-formula-why-is-this-the-case
      // Each valid [a,b,c,d] can produce 8 permutation, which
      // Swap a and b == 2 permutation
      // Swap c and d == 2 permutation
      // Swap LHS and RHS == 2 permutation
      // Thus nC2 * 8
      result += (count * (count - 1) / 2) * 8;
    }

    return result;
  }
}
