class Solution {
  public String restoreString(String s, int[] indices) {
    int n = indices.length;
    char[] characters = s.toCharArray();
    char[] reorderedCharacters = new char[n];

    for (int i = 0; i < n; i++) {
      reorderedCharacters[indices[i]] = characters[i];
    }

    return new String(reorderedCharacters);
  }
}
