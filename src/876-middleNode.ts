/** Definition for singly-linked list. */
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
}

function middleNode(head: ListNode | null): ListNode | null {
  if (!head) {
    return null;
  }

  let pointer: ListNode | null = head;
  let count = 0;

  while (pointer) {
    count++;
    pointer = pointer.next;
  }
  
  let middleIndex = (count + 2 - (count % 2)) / 2;

  for(let i = 1; i <= middleIndex; i++) {
    if (i === middleIndex) {
      return head;
    }
    head = head!.next;
  }

  return null;
};
