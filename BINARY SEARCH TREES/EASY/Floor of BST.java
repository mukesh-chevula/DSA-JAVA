// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        int floor=-1;
        while(root!=null){
            if(root.data==x) return root.data;
            else if(root.data>x) root=root.left;
            else {
                floor=root.data;
                root=root.right;
            }
        }
        return floor;
    }
}