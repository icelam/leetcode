class Solution {
  public boolean isValidIpPart(StringBuilder ip, int start, int end) {
    String part = ip.substring(start, end);

    if (
      part.length() > 3
      || (part.charAt(0) == '0' && part.length() != 1)
      || Integer.valueOf(part) > 255
    ) {
      return false;
    }

    return true;
  }

  public void backtrack(char[] characters, int start, StringBuilder currentIp, int dotAdded, List<String> result) {
    if (currentIp.length() - start > (4 - dotAdded) * 3) {
      return;
    }

    if (dotAdded == 3 && isValidIpPart(currentIp, start, currentIp.length())) {
      result.add(currentIp.toString());
      return;
    }

    if (start > characters.length || dotAdded == 3) {
      return;
    }

    for (int i = 1; i <= 3; i++) {
      int nextDotIndex = start + i;
      if (nextDotIndex >= currentIp.length()) {
        break;
      }

      if (!isValidIpPart(currentIp, start, nextDotIndex)) {
        continue;
      }

      currentIp.insert(nextDotIndex, '.');
      backtrack(characters, nextDotIndex + 1, currentIp, dotAdded + 1, result);
      currentIp.deleteCharAt(nextDotIndex);
    }
  }

  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    backtrack(s.toCharArray(), 0, new StringBuilder(s), 0, result);
    return result;
  }
}
