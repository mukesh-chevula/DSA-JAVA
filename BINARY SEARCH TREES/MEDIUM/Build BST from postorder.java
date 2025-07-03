/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG {
    public Node constructTree(int post[], int n) {
        // Add your code here.
        int[] i=new int[1];
        i[0]=n-1;
        return dfs(post,Integer.MIN_VALUE,Integer.MAX_VALUE,i);
    }
    public Node dfs(int[] arr, int lb,int ub,int[] i){
        if (i[0] < 0 || arr[i[0]] < lb || arr[i[0]] > ub) return null;

        Node root=new Node(arr[i[0]--]);
        root.right=dfs(arr,root.data,ub,i);
        root.left=dfs(arr,lb,root.data,i);
        return root;
    }
}