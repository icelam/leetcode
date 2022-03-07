/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode(Integer.MAX_VALUE);
    ListNode current = head;
    ListNode list1Pointer = list1;
    ListNode list2Pointer = list2;

    while (list1Pointer != null || list2Pointer != null) {
      int value1 = list1Pointer != null ? list1Pointer.val : Integer.MAX_VALUE;
      int value2 = list2Pointer != null ? list2Pointer.val : Integer.MAX_VALUE;
      if (value1 <= value2 && value1 != Integer.MAX_VALUE) {
        current.next = list1Pointer;
        current = current.next;
        list1Pointer = list1Pointer.next;
      } else if (value2 != Integer.MAX_VALUE) {
        current.next = list2Pointer;
        current = current.next;
        list2Pointer = list2Pointer.next;
      }
    }

    return head.next;
  }
}
