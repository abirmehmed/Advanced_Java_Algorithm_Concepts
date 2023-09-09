```
Palindrome Linked List: Given a singly linked list, determine if it is a palindrome. For example, if the input is 1 -> 2 -> 2 -> 1, the output should be true.
```

To determine if a singly linked list is a palindrome, you can use the following approach:

1. Traverse the linked list and store the values of each node in an array or a stack.
2. Reverse the array or stack.
3. Traverse the linked list again and compare each node's value with the corresponding value from the reversed array or stack.
4. If all the values match, the linked list is a palindrome. Otherwise, it is not.

Here's an example implementation in JavaScript:

```javascript
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
```

In the example above, we define a `ListNode` class to represent each node in the linked list. The `isPalindrome` function takes the head of the linked list as an argument and follows the steps outlined earlier to determine if it is a palindrome. We then create an example linked list and call the `isPalindrome` function to check if it is a palindrome. The function returns `true` in this case, indicating that the linked list is indeed a palindrome.
