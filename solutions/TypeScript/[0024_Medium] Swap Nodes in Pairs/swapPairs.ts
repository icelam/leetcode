/**
 * Definition for singly-linked list.
 */

class ListNode {
  val: number;

  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = (val === undefined ? 0 : val);
    this.next = (next === undefined ? null : next);
  }
}

function swapPairs(head: ListNode | null): ListNode | null {
  if (!head || !head.next) {
    return head;
  }

  const node1 = head;
  const node2 = node1.next;
  const node3 = node2.next;

  node2.next = node1;
  node1.next = swapPairs(node3);

  return node2;
}
