class Solution {
  public int[] deckRevealedIncreasing(int[] deck) {
    int n = deck.length;
    int[] result = new int[n];
    Queue<Integer> queue = new LinkedList<>();
    Arrays.sort(deck);

    for (int i = n - 1; i >= 0; i--) {
      if (!queue.isEmpty()) {
        queue.add(queue.remove());
      }

      queue.add(deck[i]);
    }

    for (int i = n - 1; i >= 0; i--) {
      result[i] = queue.remove();
    }

    return result;
  }
}
