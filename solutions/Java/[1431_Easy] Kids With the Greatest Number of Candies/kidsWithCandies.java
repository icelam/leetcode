class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int max = 0;
    for (int candy: candies) {
      max = Math.max(max, candy);
    }

    Boolean[] result = new Boolean[candies.length];
    for (int i = 0; i < candies.length; i++) {
      result[i] = candies[i] + extraCandies >= max;
    }

    return Arrays.asList(result);
  }
}
