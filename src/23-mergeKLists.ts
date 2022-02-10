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

function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
  let head: ListNode | null = new ListNode(0);
  let current: ListNode | null = head;
  const values: number[] = [];

  // Merge all LinkedList into 1
  for (let list of lists) {
    let node = list;
    while (node) {
      current.next = node;
      current = current.next;
      node = node.next;
    }
  }

  if (!head) {
    return head; // return null
  }

  // Insertion Sort
  current = head.next;
  let sorted: ListNode | null = null;

  while (current) {
    let next = current.next;
    let temp = null;

    if (sorted === null || sorted.val >= current.val) {
        current.next = sorted;
        sorted = current;
    } else {
      temp = sorted;
      while (temp.next !== null && temp.next.val < current.val) {
        temp = temp.next;
      }

      current.next = temp.next;
      temp.next = current;
    }

    current = next;
  }

  return sorted;
}
