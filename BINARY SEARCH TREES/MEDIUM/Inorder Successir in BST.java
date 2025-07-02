/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
        // add code here.
        Node cur=root;
        Node ans=null;
        while(cur!=null){
            if(cur.data>x.data){
                ans=cur;
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return ans!=null?ans.data:-1;
    }
}