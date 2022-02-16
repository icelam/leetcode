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
  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return head;
    }
    
    ListNode swappedListHead = new ListNode(-1, head);
    ListNode currentNode = swappedListHead.next;
    ListNode previousNode = swappedListHead;
  
    while (currentNode != null && currentNode.next != null) {
      ListNode nextNode = currentNode.next;
      previousNode.next = nextNode;
      currentNode.next = nextNode.next;
      nextNode.next = currentNode;
      previousNode = currentNode;
      currentNode = currentNode.next;
    }
  
    return swappedListHead.next;
  }
}
