class Solution {
  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public ListNode insertGreatestCommonDivisors(ListNode head) {
    ListNode node1 = head;
    ListNode node2 = head.next;

    while (node1 != null && node2 != null) {
      ListNode gcdNode = new ListNode(gcd(node1.val, node2.val), node2);
      node1.next = gcdNode;

      node1 = node2;
      node2 = node2.next;
    }

    return head;
  }
}
