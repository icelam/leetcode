class NumberContainers {
  private HashMap<Integer, Integer> numberAtIndex = new HashMap<>();
  private HashMap<Integer, PriorityQueue<Integer>> indicesOfNumber = new HashMap<>();

  public NumberContainers() { }

  public void change(int index, int number) {
    numberAtIndex.put(index, number);
    indicesOfNumber.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
  }

  public int find(int number) {
    PriorityQueue<Integer> pq = indicesOfNumber.get(number);

    if (pq == null) {
      return -1;
    }

    while (!pq.isEmpty() && numberAtIndex.get(pq.peek()) != number) {
      pq.remove();
    }

    return pq.isEmpty() ? -1 : pq.peek();
  }
}
