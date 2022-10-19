class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> count = new HashMap<>();

    for (String s: words) {
      count.put(s, count.getOrDefault(s, 0) + 1);
    }

    PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
      int occuranceA = count.get(a);
      int occuranceB = count.get(b);

      return occuranceA == occuranceB
        ? a.compareTo(b)
        : occuranceB - occuranceA;
    });

    for (String key: count.keySet()) {
      heap.add(key);
    }

    String[] result = new String[k];

    for (int i = 0; i < k; i++) {
      result[i] = heap.remove();
    }

    return Arrays.asList(result);
  }
}
