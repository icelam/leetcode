class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> result = new ArrayList();
    char[] inputs = searchWord.toCharArray();

    Arrays.sort(products);

    for (int i = 0; i < searchWord.length(); i++) {
      List<String> suggestions = new ArrayList();

      for (String p: products) {
        if (p.length() > i) {
          boolean isValidPrefix = true;

          for (int j = 0; j <= i && isValidPrefix; j++) {
            isValidPrefix &= inputs[j] == p.charAt(j);
          }

          if (isValidPrefix) {
            suggestions.add(p);
          }

          if (suggestions.size() == 3) {
            break;
          }
        }
      }

      result.add(suggestions);
    }

    return result;
  }
}
