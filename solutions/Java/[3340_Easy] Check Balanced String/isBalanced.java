class Solution {
  public boolean isBalanced(String num) {
    int i = 0;
    int[] sums = new int[2];

    for (int values: num.toCharArray()) {
      sums[i % 2] += (values - '0');
      i++;
    }

    return sums[0] == sums[1];
  }
}
