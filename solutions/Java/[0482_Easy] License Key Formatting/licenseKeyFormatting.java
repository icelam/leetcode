class Solution {
  public String licenseKeyFormatting(String s, int k) {
    char[] characters = s.toCharArray();
    StringBuilder licenseKey = new StringBuilder();

    for (int i = characters.length - 1, j = 0; i >= 0; i--) {
      if (characters[i] != '-') {
        licenseKey.append(Character.toUpperCase(characters[i]));
        j++;

        if (j % k == 0) {
          licenseKey.append('-');
        }
      }
    }

    licenseKey.reverse();

    // Handle case like s = "--a-a-a-a--", k = 2 or s = "---", k = 3
    if (licenseKey.length() > 0 && licenseKey.charAt(0) == '-') {
      licenseKey.deleteCharAt(0);
    }

    return licenseKey.toString();
  }
}
