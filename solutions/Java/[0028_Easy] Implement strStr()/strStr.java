class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        boolean isEqual = true;

        for (int j = 0; j < needle.length(); j++) {
          isEqual &= haystack.charAt(i + j) == needle.charAt(j);

          if (!isEqual) {
            break;
          }
        }

        if (isEqual) {
          return i;
        }
      }
    }

    return -1;
  }
}
