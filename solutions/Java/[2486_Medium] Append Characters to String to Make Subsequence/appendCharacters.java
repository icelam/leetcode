class Solution {
  public int appendCharacters(String s, String t) {
    char[] source = s.toCharArray();
    char[] target = t.toCharArray();
    int sPointer = 0;
    int tPointer = 0;
    int sLength = source.length;
    int tLength = target.length;

    while (sPointer < sLength && tPointer < tLength) {
      if (source[sPointer] == target[tPointer]) {
        tPointer++;
      }

      sPointer++;
    }

    return tLength - tPointer;
  }
}
