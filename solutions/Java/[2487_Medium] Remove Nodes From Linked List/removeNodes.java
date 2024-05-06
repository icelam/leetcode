class Solution {
  public ListNode removeNodes(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode next = removeNodes(head.next);

    if (next.val > head.val) {
      return next;
    }

    head.next = next;
    return head;
  }
}
