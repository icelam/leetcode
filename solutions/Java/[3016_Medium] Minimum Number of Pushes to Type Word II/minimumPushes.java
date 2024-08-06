class Solution {
  public int minimumPushes(String word) {
    char[] characters = word.toCharArray();
    int keyCount = 8;

    int[] frequencies = new int[26];

    for (char c : characters) {
      frequencies[c - 'a']++;
    }

    Arrays.sort(frequencies);

    int index = 0;
    int minPress = 0;

    while (index < 26) {
      int currentFrequency = frequencies[frequencies.length - 1 - index];

      if (currentFrequency == 0) {
        break;
      }

      minPress += currentFrequency * ((index / keyCount) + 1);
      index++;
    }

    return minPress;
  }
}
