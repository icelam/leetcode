class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int numFactoredBinaryTrees(int[] arr) {
    Arrays.sort(arr);

    long result = 1;

    HashMap<Integer, Long> map = new HashMap<>();
    map.put(arr[0], result);

    for (int i = 1; i < arr.length; i++) {
      long count = 1;

      for (int j = 0; j < i; j++) {
        boolean isIntegerQuotient = arr[i] % arr[j] == 0;
        int quotient = arr[i] / arr[j];

        if (isIntegerQuotient && map.containsKey(quotient)) {
          count = count + (map.get(quotient) * map.get(arr[j]));
        }
      }

      map.put(arr[i], count);
      result = result + count;
    }

    return (int) (result % MOD);
  }
}
