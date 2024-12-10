class Solution {
  public int maximumLength(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    Map<String, Integer> frequency = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringBuilder builder = new StringBuilder();
      builder.append(characters[i]);
      frequency.put(builder.toString(), frequency.getOrDefault(builder.toString(), 0) + 1);

      for (int j = i + 1; j < n && characters[j] == characters[i]; j++) {
        builder.append(characters[j]);
        frequency.put(builder.toString(), frequency.getOrDefault(builder.toString(), 0) + 1);
      }
    }

    int result = -1;

    for (String key: frequency.keySet()) {
      if (frequency.get(key) >= 3) {
        result = Math.max(result, key.length());
      }
    }

    return result;
  }
}
