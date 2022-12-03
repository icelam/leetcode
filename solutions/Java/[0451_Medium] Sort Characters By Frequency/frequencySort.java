class Solution {
  public String frequencySort(String s) {
    int[] count = new int['z' - '0' + 1];
    int n = s.length();
    Character[] characters = new Character[n];

    for (int i = 0; i < n; i++) {
      characters[i] = s.charAt(i);
    }

    for (char c: characters) {
      count[c - '0']++;
    }

    Arrays.sort(characters, new Comparator<Character>() {
      public int compare(Character a, Character b) {
        return count[b - '0'] == count[a - '0']
          ? b - a
          : count[b - '0'] - count[a - '0'];
      }
    });

    StringBuilder result = new StringBuilder();

    for (char c: characters) {
      result.append(c);
    }

    return result.toString();
  }
}
