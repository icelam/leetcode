class Solution {
  public int getNumberOfLeadingOnes(int n) {
    int result = 0;
    int numberOfBits = 0;

    while (n > 0) {
      int i = n & 1;

      if (i == 0) {
        result = 0;
      } else {
        result++;
      }

      n >>= 1;
      numberOfBits++;
    }

    return numberOfBits == 8 ? result : 0;
  }

  public boolean validUtf8(int[] data) {
    int index = 0;
    int length = data.length;

    while (index < length) {
      int numberOfLeadingOnes = getNumberOfLeadingOnes(data[index++]);

      if (numberOfLeadingOnes == 1 || numberOfLeadingOnes > 4) {
        return false;
      }

      if (length - index < numberOfLeadingOnes - 1) {
        return false;
      }

      for (int i = 0; i < numberOfLeadingOnes - 1; i++) {
        if (getNumberOfLeadingOnes(data[index++]) != 1) {
          return false;
        }
      }
    }

    return true;
  }
}
