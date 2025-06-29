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
        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int x = p.x;
            
            map.put(x, node);
            if (node.left != null) {
                q.offer(new Pair(node.left, x - 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, x + 1));
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (Node node : map.values()) {
            res.add(node.data);
        }
        return res;
    }
}

class Pair {
    Node node;
    int x;
    
    Pair(Node node, int x) {
        this.node = node;
        this.x = x;
    }
}

class Recursive {
    public List<Integer> bottomView(TreeNode root) {
        TreeMap<Integer, Pair> map = new TreeMap<>();
        dfsBottom(root, 0, 0, map);
        
        List<Integer> res = new ArrayList<>();
        for (Pair p : map.values()) {
            res.add(p.val);
        }
        return res;
    }

    private void dfsBottom(TreeNode node, int hd, int depth, Map<Integer, Pair> map) {
        if (node == null) return;
        
        if (!map.containsKey(hd) || depth >= map.get(hd).depth) {
            map.put(hd, new Pair(node.val, depth));
        }
        
        dfsBottom(node.left, hd - 1, depth + 1, map);
        dfsBottom(node.right, hd + 1, depth + 1, map);
    }
}