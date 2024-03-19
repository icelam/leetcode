class Solution {
  public List<String> readBinaryWatch(int turnedOn) {
    int maxBitCountForLessThanTwelve = 0;
    int maxBitCountForLessThanSixty = 0;
    List<Integer>[] bitCountMap = new ArrayList[turnedOn + 1];

    for (int i = 0; i <= turnedOn; i++) {
      bitCountMap[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < 60; i++) {
      int bitCount = Integer.bitCount(i);

      if (bitCount > turnedOn) {
        continue;
      }

      if (i < 12 && maxBitCountForLessThanTwelve < bitCount) {
        maxBitCountForLessThanTwelve = bitCount;
      }

      if (maxBitCountForLessThanSixty < bitCount) {
        maxBitCountForLessThanSixty = bitCount;
      }

      bitCountMap[bitCount].add(i);
    }

    StringBuilder builder = new StringBuilder();
    List<String> result = new ArrayList<>();
    int maxHourBitBoundary = Math.min(maxBitCountForLessThanTwelve, turnedOn);

    for (int i = 0; i <= maxHourBitBoundary; i++) {
      if (turnedOn - i > maxBitCountForLessThanSixty) {
        continue;
      }

      for (int hour: bitCountMap[i]) {
        if (hour >= 12) {
          break;
        }

        builder.append(hour);
        builder.append(':');

        for (int minute: bitCountMap[turnedOn - i]) {
          if (minute < 10) {
            builder.append(0);
          }

          builder.append(minute);
          result.add(builder.toString());
          builder.delete(builder.length() - 2, builder.length());
        }

        builder.delete(0, builder.length());
      }
    }

    return result;
  }
}
