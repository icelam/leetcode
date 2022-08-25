class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] magazineCharCount = new int[26];
    int[] ransomNoteCharCount = new int[26];

    for (char c: magazine.toCharArray()) {
      magazineCharCount[c - 'a']++;
    }

    for (char c: ransomNote.toCharArray()) {
      ransomNoteCharCount[c - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
      if (magazineCharCount[i] < ransomNoteCharCount[i]) {
        return false;
      }
    }

    return true;
  }
}
