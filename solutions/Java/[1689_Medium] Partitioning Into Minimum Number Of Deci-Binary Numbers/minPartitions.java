class Solution {
  public int minPartitions(String n) {
    int max = '0';
    char[] characters = n.toCharArray();

    for (int c: characters) {
      max = Math.max(c, max);
    }

    return max - '0';
  }
}
