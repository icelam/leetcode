class Solution {
  private HashSet<String> combination;
  private boolean[] used;

  private void backtrack(char[] characters, StringBuilder builder, int index) {
    if (index == characters.length) {
      return;
    }

    for (int i = 0; i < characters.length; i++) {
      char c = characters[i];

      if (used[i]) {
        continue;
      }

      used[i] = true;
      builder.append(c);
      combination.add(builder.toString());
      backtrack(characters, builder, index + 1);
      builder.deleteCharAt(builder.length() - 1);
      used[i] = false;
    }
  }

  public int numTilePossibilities(String tiles) {
    char[] characters = tiles.toCharArray();
    used = new boolean[characters.length];
    combination = new HashSet<>();
    backtrack(characters, new StringBuilder(), 0);
    return combination.size();
  }
}
