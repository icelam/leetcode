class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode previous = null;
    ListNode current = head;

    while (current != null) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    return previous;
  }

  public ListNode doubleIt(ListNode head) {
    head = reverseList(head);
    ListNode currentNode = head;

    // Carry will never be > 1,
    // since (9 * 2) + 1 = 19 -> 19 / 10 = 1
    //        ^        ^
    //    max digit  carry
    Boolean isCarryNeeded = false;

    while (currentNode != null) {
      int doubledValue = currentNode.val * 2;
      currentNode.val = (doubledValue % 10) + (isCarryNeeded ? 1 : 0);
      isCarryNeeded = doubledValue >= 10;
      currentNode = currentNode.next;
    }

    head = reverseList(head);

    if (isCarryNeeded) {
      return new ListNode(1, head);
    }

    return head;
  }
}
