class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] nge=new int[n];


        Stack<Integer> stack=new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int ele = nums[i];
            while (!stack.isEmpty() && stack.peek() <= ele) {
                stack.pop();
            }
            stack.push(ele);
        }

        for (int i = n - 1; i >= 0; i--) {
            int ele = nums[i];
            while (!stack.isEmpty() && stack.peek() <= ele) {
                stack.pop();
            }
            nge[i]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(ele);
        }

        return nge;
    }
}