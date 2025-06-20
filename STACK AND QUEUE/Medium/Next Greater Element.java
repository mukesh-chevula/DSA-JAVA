class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2=nums2.length;
        int n1=nums1.length;
        HashMap<Integer,Integer> nge=new HashMap<>();

        Stack<Integer> stack=new Stack<>();
        for(int i=n2-1;i>=0;i--){
            int ele=nums2[i];
            if(stack.empty()){
                nge.put(nums2[i],-1);
                stack.push(ele);
            }
            if(stack.peek()>ele){
                nge.put(nums2[i],stack.peek());
                stack.push(ele);
            }else{
                while(!stack.empty() && stack.peek()<=ele) stack.pop();
                if(stack.empty()){
                    nge.put(nums2[i],-1);
                    stack.push(ele);
                    continue;
                }
                nge.put(nums2[i],stack.peek());
                stack.push(ele);
            }
        }
        int[] res= new int[n1];
        for(int i=0;i<n1;i++){
            res[i]=nge.get(nums1[i]);
        }
        return res;
    }
}