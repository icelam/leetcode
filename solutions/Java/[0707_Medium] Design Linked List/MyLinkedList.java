class MyLinkedList {
  private ListNode head;
  private ListNode tail;
  private int length;

  public class ListNode {
    private int val;
    private ListNode next;
    ListNode() { }
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val; this.next = next;
    }
  }

  public MyLinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public int get(int index) {
    if (index >= this.length) {
      return -1;
    }

    if (index == this.length - 1) {
      return this.tail.val;
    }

    ListNode target = head;

    for (int i = 0; i < index; i++) {
      target = target.next;
    }

    return target.val;
  }

  public void addAtHead(int val) {
    ListNode temp = this.head;
    this.head = new ListNode(val, temp);

    if (this.length == 0) {
      this.tail = this.head;
    }

    this.length++;
  }

  public void addAtTail(int val) {
    ListNode newNode = new ListNode(val);

    if (this.length == 0) {
      this.head = newNode;
    } else {
      this.tail.next = newNode;
    }

    this.tail = newNode;
    this.length++;
  }

  public void addAtIndex(int index, int val) {
    if (index > this.length) {
      return;
    }

    if (index == 0) {
      addAtHead(val);
    } else if (index == this.length) {
      addAtTail(val);
    } else {
      ListNode target = head;
      for (int i = 0; i < index - 1; i++) {
        target = target.next;
      }

      ListNode temp = target.next;
      target.next = new ListNode(val, temp);
      this.length++;
    }
  }

  public void deleteAtIndex(int index) {
    if (index >= this.length) {
      return;
    }

    ListNode target = head;
    for (int i = 0; i < index - 1; i++) {
      target = target.next;
    }

    if (index == 0) {
      this.head = target.next;
    } else if (index == this.length - 1) {
      target.next = null;
      this.tail = target;
    } else {
      target.next = target.next.next;
    }

    this.length--;
  }
}
