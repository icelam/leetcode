class Solution {
  public int calculateBitsRequired(int k) {
    return (1 << k) - 1 + k;
  }

  public boolean isValidStringLength(String s, int k) {
    return s.length() >= calculateBitsRequired(k);
  }

  public boolean isSetComplete(HashSet<String> set, int k) {
    return set.size() == (1 << k);
  }

  public boolean hasAllCodes(String s, int k) {
    if (!isValidStringLength(s, k)) {
      return false;
    }

    int minBitsRequired = calculateBitsRequired(k);
    HashSet<String> set = new HashSet<>();

    for (int start = 0, end = k; end <= s.length(); start++, end++) {
      set.add(s.substring(start, end));

      int remainingBits = s.length() - end;
      int bitsInSet = set.size() * k;
      if (remainingBits < minBitsRequired - bitsInSet || isSetComplete(set, k)) {
        break;
      }
    }

    return isSetComplete(set, k);
  }
}
