class Solution {
  public boolean validUtf8(int[] data) {
    int index = 0;
    int length = data.length;

    while (index < length) {
      int numberOfLeadingOnes = 0;

      if (data[index] < (2 << 6)) {
        numberOfLeadingOnes = 0;
      } else if (data[index] >= 0b11110000 && data[index] <= 0b11110111) {
        numberOfLeadingOnes = 4;
      } else if (data[index] >= 0b11100000 && data[index] <= 0b11101111) {
        numberOfLeadingOnes = 3;
      } else if (data[index] >= 0b11000000 && data[index] <= 0b11011111) {
        numberOfLeadingOnes = 2;
      } else {
        return false;
      }

      index++;

      if (length - index < numberOfLeadingOnes - 1) {
        return false;
      }

      for (int i = 0; i < numberOfLeadingOnes - 1; i++) {
        if (data[index] < 0b10000000 || data[index] > 0b10111111) {
          return false;
        }

        index++;
      }
    }

    return true;
  }
}
