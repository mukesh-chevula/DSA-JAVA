/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
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
    static ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer, Node> map=new TreeMap<>();
        Queue<Pair> q=new ArrayDeque();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node node= p.node;
            int x=p.x;
            
            map.putIfAbsent(x,node);
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
}

class Recursive {
    private static class Pair {
        int val, depth;
        Pair(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }

    public List<Integer> topView(TreeNode root) {
        Map<Integer, Pair> topNodes = new TreeMap<>();
        dfs(root, 0, 0, topNodes);

        List<Integer> result = new ArrayList<>();
        for (Pair pair : topNodes.values()) {
            result.add(pair.val);
        }
        return result;
    }

    private void dfs(TreeNode node, int hd, int depth, Map<Integer, Pair> map) {
        if (node == null) return;

        if (!map.containsKey(hd) || depth < map.get(hd).depth) {
            map.put(hd, new Pair(node.val, depth));
        }

        dfs(node.left, hd - 1, depth + 1, map);
        dfs(node.right, hd + 1, depth + 1, map);
    }
}
