class Solution {
  private static int WORD_LENGTH = 2;

  public String reverseString(String s) {
    StringBuilder builder = new StringBuilder(s);
    return builder.reverse().toString();
  }

  public int longestPalindrome(String[] words) {
    HashMap<String, Integer> count = new HashMap<>();

    for (String w: words) {
      count.put(w, count.getOrDefault(w, 0) + 1);
    }

    HashSet<String> processed = new HashSet<>();

    int maxLength = 0;
    boolean isMiddleOccupied = false;

    for (String key: count.keySet()) {
      if (processed.contains(key)) {
        continue;
      }

      processed.add(key);

      if (key.charAt(0) == key.charAt(1)) {
        int currentCount = count.get(key);
        boolean isOddCount = currentCount % 2 == 1;

        maxLength += (currentCount - (currentCount % 2)) * WORD_LENGTH;

        if (isOddCount && !isMiddleOccupied) {
          maxLength += WORD_LENGTH;
          isMiddleOccupied = true;
        }

        continue;
      }

      String reversedKey = reverseString(key);
      if (count.containsKey(reversedKey)) {
        processed.add(reversedKey);
        int minCount = Math.min(count.get(key), count.get(reversedKey));
        maxLength += minCount * 2 * WORD_LENGTH;
      }
    }

    return maxLength;
  }
}
