/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    boolean isLeaf(Node node){
        return (node.left==null)&&(node.right==null);
    }
    void addLeft(Node node,ArrayList<Integer> ans){
        Node cur=node.left;
        while(cur!=null){
            if (!isLeaf(cur)) ans.add(cur.data);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    void addRight(Node node,ArrayList<Integer> ans){
        LinkedList<Integer> dq = new LinkedList<>();
        Node cur = node.right;
        while (cur != null) {
            if (!isLeaf(cur)) dq.addFirst(cur.data);
            if (cur.right != null) 
                cur = cur.right;
            else 
                cur = cur.left;
        }
        while (!dq.isEmpty()) {
            ans.add(dq.removeFirst());
        }
    }
    
    void addLeaf(Node node,ArrayList<Integer> ans){
        if(isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        if(node.left!=null) addLeaf(node.left,ans);
        if(node.right!=null) addLeaf(node.right,ans);
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        if(isLeaf(node)==false) ans.add(node.data);
        addLeft(node,ans);
        addLeaf(node,ans);
        addRight(node,ans);
        return ans;
    }
}