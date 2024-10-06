class Solution {
  public boolean areSentencesSimilar(String sentence1, String sentence2) {
    String[] words1 = sentence1.split(" ");
    String[] words2 = sentence2.split(" ");

    if (words1.length > words2.length) {
      String[] temp = words1;
      words1 = words2;
      words2 = temp;
    }

    int start = 0;
    int ends1 = words1.length - 1;
    int ends2 = words2.length - 1;

    while (start < words1.length && words1[start].equals(words2[start])) {
      start++;
    }

    while (ends1 >= 0 && words1[ends1].equals(words2[ends2])) {
      ends1--;
      ends2--;
    }

    return ends1 < start;
  }
}
