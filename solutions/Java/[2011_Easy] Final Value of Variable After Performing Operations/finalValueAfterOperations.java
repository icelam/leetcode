class Solution {
  public int finalValueAfterOperations(String[] operations) {
    int result = 0;

    for (String o: operations) {
      if (o.equals("++X") || o.equals("X++")) {
        result++;
      } else {
        result--;
      }
    }

    return result;
  }
}
