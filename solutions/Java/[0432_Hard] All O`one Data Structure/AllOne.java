class Node {
  public int count;
  public Set<String> set;
  public Node previous;
  public Node next;

  Node(int count) {
    this.set = new HashSet<>();
    this.count = count;
    previous = null;
    next = null;
  }
}

class DoublyLinkedList {
  private Node head;
  private Node tail;
  private int size;

  public DoublyLinkedList() {
    head = new Node(0);
    tail = new Node(0);
    head.next = tail;
    tail.previous = head;
  }

  public void insertBefore(Node node, Node target) {
    node.previous = target.previous;
    node.next = target;
    target.previous.next = node;
    target.previous = node;
  }

  public void insertAfter(Node node, Node target) {
    node.next = target.next;
    node.previous = target;
    target.next.previous = node;
    target.next = node;
  }

  public void addFirst(Node node) {
    insertAfter(node, head);
  }

  public void addLast(Node node) {
    insertBefore(node, tail);
  }

  public void remove(Node node) {
    node.previous.next = node.next;
    node.next.previous = node.previous;
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

  public Node getFirst() {
    if (head.next == tail) {
      return null;
    }

    return head.next;
  }

  public Node getLast() {
    if (tail.previous == head) {
      return null;
    }

    return tail.previous;
  }
}

class AllOne {
  private Map<String, Node> map;
  DoublyLinkedList counts;

  public AllOne() {
    map = new HashMap<>();
    counts = new DoublyLinkedList();
  }

  public void inc(String key) {
    if (!map.containsKey(key)) {
      Node node = counts.getFirst();

      if (node == null || node.count != 1) {
        node = new Node(1);
        counts.addFirst(node);
      }

      node.set.add(key);
      map.put(key, node);
      return;
    }

    Node node = map.get(key);
    Node next = null;

    node.set.remove(key);

    if (node.next.count == node.count + 1) {
      next = node.next;
    } else {
      next = new Node(node.count + 1);
      counts.insertAfter(next, node);
    }

    next.set.add(key);
    map.put(key, next);

    if (node.set.size() == 0) {
      counts.remove(node);
    }
  }

  public void dec(String key) {
    Node node = map.get(key);

    node.set.remove(key);

    if (node.count == 1) {
      map.remove(key);
    } else {
      Node previous = null;

      if (node.previous.count == node.count - 1) {
        previous = node.previous;
      } else {
        previous = new Node(node.count - 1);
        counts.insertBefore(previous, node);
      }

      previous.set.add(key);
      map.put(key, previous);
    }

    if (node.set.size() == 0) {
      counts.remove(node);
    }
  }

  public String getMaxKey() {
    Node node = counts.getLast();

    if (node != null) {
      for (String key: node.set) {
        return key;
      }
    }

    return "";
  }

  public String getMinKey() {
    Node node = counts.getFirst();

    if (node != null) {
      for (String key: node.set) {
        return key;
      }
    }

    return "";
  }
}
