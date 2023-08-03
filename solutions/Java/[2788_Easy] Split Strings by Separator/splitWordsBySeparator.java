class Solution {
  public List<String> splitWordsBySeparator(List<String> words, char separator) {
    List<String> result = new ArrayList<>();

    for (String w: words) {
      char[] characters = w.toCharArray();
      StringBuilder builder = new StringBuilder();

      for (int i = 0; i <= characters.length; i++) {
        if (i == characters.length || characters[i] == separator) {
          if (builder.length() > 0) {
            result.add(builder.toString());
            builder.delete(0, builder.length());
          }
          continue;
        }

        builder.append(characters[i]);
      }
    }

    return result;
  }
}
