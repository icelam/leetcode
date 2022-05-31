class Solution {
  public boolean isValidStringLength(String s, int k) {
    return s.length() >= Math.pow(2, k) - 1 + k;
  }

  public boolean isSetComplete(HashSet<String> set, int k) {
    return set.size() == Math.pow(2, k);
  }

  public boolean hasAllCodes(String s, int k) {
    if (!isValidStringLength(s, k)) {
      return false;
    }

    HashSet<String> set = new HashSet<>();

    char[] c = s.toCharArray();

    for (int i = k; i <= s.length() && !(isSetComplete(set, k)); i++) {
      set.add(s.substring(i - k, i));
    }

    return set.size() == Math.pow(2, k);
  }
}
