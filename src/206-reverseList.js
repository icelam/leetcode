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
var reverseList = function(head) {
  /* --- Recursive Method --- */
  if(!head || !head.next) {
    return head;
  }

  let parent = reverseList(head.next);
  head.next.next = head;
  head.next = null;
  return parent;
  /* --- End Recursive Method --- */

  /* --- Iterative Method --- */
  /* var previous = null;
  var current = head;

  while (current != null) {
    let next = current.next;
    current.next = previous;
    previous = current;
    current = next;
  }

  return previous; */
  /* --- End Iterative Method --- */
};
