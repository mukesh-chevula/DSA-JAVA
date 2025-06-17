public class Solution {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int top = stack.pop();<145662081+mukesh-chevula@users.noreply.github.com>
        insertAtBottom(stack, item);
        stack.push(top);
    } 

}