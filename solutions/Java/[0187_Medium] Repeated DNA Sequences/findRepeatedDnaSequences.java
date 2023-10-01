class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    int n = s.length();
    List<String> result = new ArrayList<>();
    HashMap<String, Integer> frequency = new HashMap<>();

    for (int i = 0; i <= n - 10; i++) {
      String dnaSubsequence = s.substring(i, i + 10);

      int count = frequency.getOrDefault(dnaSubsequence, 0) + 1;
      frequency.put(dnaSubsequence, count);

      if (count == 2) {
        result.add(dnaSubsequence);
      }
    }

    return result;
  }
}
