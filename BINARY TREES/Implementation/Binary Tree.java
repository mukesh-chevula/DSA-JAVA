public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    private static class Node {
        int value;
        Node left, right;

        Node(int item) {
            value = item;
            left = right = null;
        }
    }
}