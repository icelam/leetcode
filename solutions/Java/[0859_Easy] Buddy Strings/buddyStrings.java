class Solution {
  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length()) {
      return false;
    }

    char[] sChar = s.toCharArray();
    char[] gChar = goal.toCharArray();
    int[] sFrequencies = new int[26];
    int[] gFrequencies = new int[26];
    boolean isStringMatch = true;

    for (int i = 0; i < sChar.length; i++) {
      sFrequencies[sChar[i] - 'a']++;
      gFrequencies[gChar[i] - 'a']++;

      isStringMatch = isStringMatch && sChar[i] == gChar[i];
    }

    boolean sHasMultipleSameChar = false;
    boolean hasEqualCharFrequencies = true;

    for (int j = 0; j < 26; j++) {
      if (sFrequencies[j] > 1) {
        sHasMultipleSameChar = true;
      }

      if (sFrequencies[j] != gFrequencies[j]) {
        hasEqualCharFrequencies = false;
        break;
      }
    }

    if ((isStringMatch && !sHasMultipleSameChar) || !hasEqualCharFrequencies) {
      return false;
    }

    int[] indicesToSwap = new int[2];
    int index = 0;

    for (int k = 0; k < sChar.length; k++) {
      if (sChar[k] != gChar[k]) {
        if (index < 2) {
          indicesToSwap[index] = k;
          index++;
        } else {
          return false;
        }
      }
    }

    return (
      sChar[indicesToSwap[0]] == gChar[indicesToSwap[1]]
      && sChar[indicesToSwap[1]] == gChar[indicesToSwap[0]]
    );
  }
}
