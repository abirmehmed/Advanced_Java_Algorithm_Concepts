#
Largest Rectangle in Histogram: Given an array of non-negative integers representing the heights of bars in a histogram, find the area of the largest rectangle that can be formed within the histogram. For example, if the input is [2, 1, 5, 6, 2, 3], the output should be 10.
#

The problem you are referring to is known as the "Largest Rectangle in Histogram" problem. This problem can be solved using a stack-based approach in linear time complexity.

Here's the step-by-step algorithm to solve the problem:

1. Create an empty stack and initialize a variable `maxArea` to 0.

2. Iterate through each bar in the histogram from left to right.

3. For each bar, do the following:
   - If the stack is empty or the current bar's height is greater than or equal to the height of the bar at the top of the stack, push the index of the current bar onto the stack.
   - If the current bar's height is less than the height of the bar at the top of the stack, it means we have found the right boundary for some bars in the stack. Pop the top bar from the stack and calculate the area of the rectangle that can be formed using the popped bar as the minimum height. The width of the rectangle is the difference between the current index and the index of the new top bar in the stack (or the current index if the stack is empty after the pop operation). Update `maxArea` if the calculated area is greater than the current maximum area.
   - Repeat the above step until the current bar's height is greater than or equal to the height of the new top bar in the stack.

4. After the iteration, if the stack is not empty, it means there are remaining bars for which the right boundary is the end of the histogram. Pop each remaining bar from the stack and calculate the area of the rectangle that can be formed using the popped bar as the minimum height. Update `maxArea` if the calculated area is greater than the current maximum area.

5. Return the value of `maxArea`, which represents the area of the largest rectangle that can be formed within the histogram.

Here's the Java code implementation of the algorithm:

```java
import java.util.Stack;

public class Main {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;

        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangleArea(heights);
        System.out.println("The area of the largest rectangle in the histogram is: " + maxArea); // Output: 10
    }
}
```

The `largestRectangleArea` method takes an array of non-negative integers representing the heights of bars in the histogram and returns the area of the largest rectangle that can be formed within the histogram.

In the `main` method, we create an example histogram array `[2, 1, 5, 6, 2, 3]` and pass it to the `largestRectangleArea` method. Finally, we print the result.

The time complexity of this algorithm is O(n), where n is the number of bars in the histogram, as we iterate through each bar only once. The space complexity is O(n) as well because the stack can potentially hold all the bars in the worst case.
