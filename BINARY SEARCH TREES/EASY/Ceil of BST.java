/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Tree {
    Node prev=null;
    int findCeil(Node root, int key) {
        // code here
        int ceil=-1;
        while(root!=null){
            if(root.data==key){
                return root.data;
            }else if(root.data>key){
                ceil=root.data;
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return ceil;
    }
}