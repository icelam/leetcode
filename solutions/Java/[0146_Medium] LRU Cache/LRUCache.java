
class LRUCache {
  class Node {
    public int key;
    public int value;
    public Node next;
    public Node previous;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.previous = head;
      size = 0;
    }

    public int size() {
      return size;
    }

    public void remove(Node node) {
      node.previous.next = node.next;
      node.next.previous = node.previous;
      size--;
    }

    public void addFirst(Node node) {
      node.next = head.next;
      node.previous = head;
      head.next.previous = node;
      head.next = node;
      size++;
    }

    public void addLast(Node node) {
      node.previous = tail.previous;
      node.next = tail;
      tail.previous.next = node;
      tail.previous = node;
      size++;
    }

    public Node removeFirst() {
      if (head.next == tail) {
        return null;
      }

      Node first = head.next;
      remove(first);
      return first;
    }

    public Node removeLast() {
      if (tail.previous == head) {
        return null;
      }

      Node last = tail.previous;
      remove(last);
      return last;
    }
  }

  private HashMap<Integer, Node> cache;
  private DoublyLinkedList history;
  private int size;

  public LRUCache(int capacity) {
    this.size = capacity;
    cache = new HashMap<>();
    history = new DoublyLinkedList();
  }

  private void makeRecently(int key) {
    Node node = cache.get(key);
    history.remove(node);
    history.addLast(node);
  }

  private void markAsRecentlyUsed(int key, int val) {
    Node node = new Node(key, val);
    history.addLast(node);
    cache.put(key, node);
  }

  private void deleteKeyFromCache(int key) {
    Node node = cache.get(key);
    history.remove(node);
    cache.remove(key);
  }

  private void removeLeastRecentlyUsedCache() {
    Node deletedNode = history.removeFirst();
    int deletedKey = deletedNode.key;
    cache.remove(deletedKey);
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    makeRecently(key);
    return cache.get(key).value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      deleteKeyFromCache(key);
      markAsRecentlyUsed(key, value);
      return;
    }

    if (size == history.size()) {
      removeLeastRecentlyUsedCache();
    }

    markAsRecentlyUsed(key, value);
  }
}
