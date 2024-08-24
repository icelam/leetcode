class Solution {
  private long getNum(long num, boolean isEven) {
    StringBuilder builder = new StringBuilder();
    builder.append(num);

    int n = builder.length();
    int index = isEven ? n - 1 : n - 2;

    while (index >= 0) {
      builder.append(builder.charAt(index));
      index--;
    }

    return builder.length() > 19 ? -1 : Long.parseLong(builder.toString());
  }

  public String nearestPalindromic(String n) {
    int length = n.length();
    long num = Long.parseLong(n);

    HashSet<Long> set = new HashSet<>();
    set.add((long) Math.pow(10, (length - 1)) - 1);
    set.add((long) Math.pow(10, length) + 1);

    long firstPart = Long.parseLong(n.substring(0, (length + 1) / 2));

    for (long i = firstPart - 1; i <= firstPart + 1; i++) {
      long newNum = getNum(i, length % 2 == 0);

      if (newNum != num) {
        set.add(newNum);
      }
    }

    long result = Long.MAX_VALUE;

    for (long newNum: set) {
      if (
        Math.abs(newNum - num) < Math.abs(result - num)
        || (Math.abs(newNum - num) == Math.abs(result - num) && newNum < result)
      ) {
        result = newNum;
      }
    }

    return String.valueOf(result);
  }
}
