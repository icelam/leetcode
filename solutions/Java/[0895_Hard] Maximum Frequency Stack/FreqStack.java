class FreqStack {
  private int position;
  private HashMap<Integer, Integer> count;
  private PriorityQueue<StackItem> priorityQueue;

  public class StackItem {
    private int value;
    private int frequency;
    private int position;

    StackItem(int value, int frequency, int position) {
      this.value = value;
      this.frequency = frequency;
      this.position = position;
    }
  }

  FreqStack() {
    position = -1;
    count = new HashMap<Integer, Integer>();
    priorityQueue = new PriorityQueue<StackItem>((a, b) -> (
      b.frequency == a.frequency
        ? b.position - a.position
        : b.frequency - a.frequency
    ));
  }

  public void push(int val) {
    count.put(val, count.getOrDefault(val, 0) + 1);
    position++;
    priorityQueue.add(new StackItem(val, count.get(val), position));
  }

  public int pop() {
    StackItem mostFrequentItem = priorityQueue.poll();
    int key = mostFrequentItem.value;

    count.put(key, count.get(key) - 1);

    return key;
  }
}
