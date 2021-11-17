/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  if (!head || !head.next) {
    return head;
  }

  var node1 = head;
  var node2 = node1.next;
  var node3 = node2.next;

  node2.next = node1;
  node1.next = swapPairs(node3);

  return node2;
};
