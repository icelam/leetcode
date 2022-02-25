class Solution {
  public int compareVersion(String version1, String version2) {
    int i = 0;
    int j = 0;
    boolean pause1 = false;
    boolean pause2 = false;

    String buffer1 = "";
    String buffer2 = "";

    while (i < version1.length()  || j < version2.length()) {
      if (i < version1.length() && !pause1) {
        if (version1.charAt(i) == '.') {
          pause1 = true;
        } else if (!(buffer1.length() == 0 && version1.charAt(i) == '0')) {
          buffer1 += version1.charAt(i);
        }

        i++;
      } else {
        pause1 = true;
      }

      if (j < version2.length() && !pause2) {
        if (version2.charAt(j) == '.') {
          pause2 = true;
        } else if (!(buffer2.length() == 0 && version2.charAt(j) == '0')) {
          buffer2 += version2.charAt(j);
        }

        j++;
      } else {
        pause2 = true;
      }

      if (pause1 && pause2 || (i == version1.length()  &&  j == version2.length())) {
        if (buffer1.length() > buffer2.length()) {
          return 1;
        }

        if (buffer1.length() < buffer2.length()) {
          return -1;
        }

        for (int k = 0; k < buffer1.length(); k++) {
          if (buffer1.charAt(k) > buffer2.charAt(k)) {
            return 1;
          }

          if (buffer1.charAt(k) < buffer2.charAt(k)) {
            return -1;
          }
        }

        pause1 = (i == version1.length());
        pause2 = (j == version2.length());
        buffer1 = "";
        buffer2 = "";
      }
    }

    return 0;
  }
}
