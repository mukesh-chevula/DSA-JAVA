/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        TreeMap<Integer, Node> map=new TreeMap<>();
        Queue<Pair> q=new ArrayDeque();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node node= p.node;
            int x=p.x;
            
            map.put(x,node);
            if(node.left!=null){
                q.offer(new Pair(node.left,x-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,x+1));
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(Node node:map.values()){
            res.add(node.data);
        }
        return res;
    }

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static class Pair{
        Node node;
        int x;
        Pair(Node node,int x){
            this.node=node;
            this.x=x;
        }
    }
}