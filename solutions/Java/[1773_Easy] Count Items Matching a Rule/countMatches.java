class Solution {
  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int result = 0;
    int propertyID = ruleKey.equals("type")
      ? 0
      : ruleKey.equals("color")
        ? 1
        : 2;

    for (List<String> item: items) {
      if (item.get(propertyID).equals(ruleValue)) {
        result++;
      }
    }

    return result;
  }
}
