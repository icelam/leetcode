/**
 * Definition for singly-linked list.
 */

class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
  }
}


function insertionSortList(head: ListNode | null): ListNode | null {
  let sorted: ListNode | null = null;

  let current = head;
  // Traverse the given linked list and insert every node to sorted
  while (current != null) {
    // Store next for next iteration
    let next = current.next;
    // insert current in sorted linked list
    /* Special case for the head end */
    if (sorted === null || sorted.val >= current.val) {
        current.next = sorted;
        sorted = current;
    } else {
        let temp = sorted;
        /* Locate the node before the point of insertion */
        while (temp.next != null && temp.next.val < current.val) {
            temp = temp.next;
        }
        current.next = temp.next;
        temp.next = current;
    }
    // Update current
    current = next;
  }

  return sorted;
}
