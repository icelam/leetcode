/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
  public ListNode detectCycle(ListNode head) {
   if (head == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        ListNode pointer = head;

        while (pointer != slow) {
          pointer = pointer.next;
          slow = slow.next;
        }

        return pointer;
      }
    }

    return null;
  }
}
