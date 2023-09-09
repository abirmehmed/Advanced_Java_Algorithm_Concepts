class ListNode {
  constructor(val, next = null) {
    this.val = val;
    this.next = next;
  }
}

function isPalindrome(head) {
  // Step 1: Store node values in an array
  const values = [];
  let current = head;
  while (current) {
    values.push(current.val);
    current = current.next;
  }

  // Step 2: Reverse the array
  const reversed = values.slice().reverse();

  // Step 3: Compare values
  for (let i = 0; i < values.length; i++) {
    if (values[i] !== reversed[i]) {
      return false;
    }
  }

  // Step 4: All values match, it is a palindrome
  return true;
}

// Example usage

// Create a palindrome linked list: 1 -> 2 -> 2 -> 1
const node4 = new ListNode(1);
const node3 = new ListNode(2, node4);
const node2 = new ListNode(2, node3);
const node1 = new ListNode(1, node2);

console.log(isPalindrome(node1)); // Output: true
