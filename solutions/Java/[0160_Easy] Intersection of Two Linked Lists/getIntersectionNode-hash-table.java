/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    HashSet<ListNode> set = new HashSet<>();

    ListNode current = headA;

    while (current != null) {
      set.add(current);
      current = current.next;
    }

    current = headB;

    while (current != null) {
      if (set.contains(current)) {
        return current;
      }
      current = current.next;
    }

    return null;
  }
}
