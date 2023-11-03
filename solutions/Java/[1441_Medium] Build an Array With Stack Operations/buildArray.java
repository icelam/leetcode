class Solution {
  private String PUSH_OPERATION = "Push";
  private String POP_OPERATION = "Pop";

  public List<String> buildArray(int[] target, int n) {
    int stream = 1;
    List<String> result = new ArrayList<>();

    for (int num: target) {
      while (stream < num && stream < n) {
        stream++;
        result.add(PUSH_OPERATION);
        result.add(POP_OPERATION);
      }

      result.add(PUSH_OPERATION);
      stream++;
    }

    return result;
  }
}
