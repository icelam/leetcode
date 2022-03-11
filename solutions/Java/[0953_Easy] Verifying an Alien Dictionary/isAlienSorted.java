class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    HashMap<Character, Integer> dictionary = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      dictionary.put(order.charAt(i), i);
    }

    for (int i = 1; i < words.length; i++) {
      for (int j = 0; j < Math.max(words[i - 1].length(), words[i].length()); j++) {
        int c1 = j < words[i - 1].length()
          ? dictionary.get(words[i - 1].charAt(j))
          : -1;
        int c2 = j < words[i].length()
          ? dictionary.get(words[i].charAt(j))
          : -1;

        if (c1 < c2) {
          break;
        }

        if (c1 > c2) {
          return false;
        }
      }
    }

    return true;
  }
}
