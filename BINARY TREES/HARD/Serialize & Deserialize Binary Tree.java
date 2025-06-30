/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder();
        _serialize(root,str);
        return str.toString();
    }
    public void _serialize(TreeNode root,StringBuilder str){
        if(root==null){
            str.append("_ ");
            return;
        }
        str.append(root.val).append(" ");
        _serialize(root.left,str);
        _serialize(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(" ")));
        return _deserialize(q);
    }
    public TreeNode _deserialize(Queue<String> q){
        if(q.isEmpty()) return null;

        String val=q.poll();

        if (val.equals("_")) return null;

        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=_deserialize(q);
        node.right=_deserialize(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));