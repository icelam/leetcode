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
  public void reorderList(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode current = head;
    ListNode temp = null;
    ListNode previous = null;

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    current = slow.next;
    slow.next = null;
    while (current != null) {
      temp = current.next;
      current.next = previous;
      previous = current;
      current = temp;
    }

    ListNode list1 = head;
    ListNode list2 = previous;
    while (list2 != null) {
      temp = list1.next;
      list1.next = list2;
      list1 = temp;
      temp = list2.next;
      list2.next = list1;
      list2 = temp;
    }
  }
}
