import java.util.NoSuchElementException;

/**
 * A binary min-heap implementation using an explicit binary tree structure.
 * In a min-heap, the value of each node is less than or equal to the value of its children.
 * The root of the heap is the smallest element.
 */
public class BinaryMinHeap {

    /**
     * Inner class to represent a node in the binary tree.
     */
    private static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private int size;

    /**
     * Constructs an empty BinaryMinHeap.
     */
    public BinaryMinHeap() {
        root = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the heap.
     * @return the size of the heap.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the heap is empty.
     * @return true if the heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a new element to the heap, maintaining the heap property.
     * @param item The element to add.
     */
    public void add(int item) {
        Node newNode = new Node(item);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        size++;
        // Find the parent for the new node to maintain the complete tree property.
        // The parent of the node at index `k` is at index `k/2`.
        Node parent = getNode(size / 2);
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;

        heapifyUp(newNode);
    }

    /**
     * Retrieves, but does not remove, the minimum element of this heap.
     * @return The minimum element.
     * @throws NoSuchElementException if the heap is empty.
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return root.value;
    }

    /**
     * Retrieves and removes the minimum element of this heap.
     * @return The minimum element.
     * @throws NoSuchElementException if the heap is empty.
     */
    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        int minItem = root.value;

        if (size == 1) {
            root = null;
            size = 0;
            return minItem;
        }

        // Get the last node in the heap
        Node lastNode = getNode(size);
        // Move the last node's value to the root
        root.value = lastNode.value;

        // Remove the last node
        if (lastNode.parent.left == lastNode) {
            lastNode.parent.left = null;
        } else {
            lastNode.parent.right = null;
        }
        lastNode.parent = null; // Help GC

        size--;

        heapifyDown(root);

        return minItem;
    }

    /**
     * Restores the heap property by moving a node up towards the root.
     * @param node The node to start heapifying up from.
     */
    private void heapifyUp(Node node) {
        while (node.parent != null && node.parent.value > node.value) {
            swapValues(node.parent, node);
            node = node.parent;
        }
    }

    /**
     * Restores the heap property by moving a node down from the root.
     * @param node The node to start heapifying down from.
     */
    private void heapifyDown(Node node) {
        Node current = node;
        while (current.left != null) { // While there is at least a left child
            Node smallerChild = current.left;
            if (current.right != null && current.right.value < smallerChild.value) {
                smallerChild = current.right;
            }

            if (current.value < smallerChild.value) {
                break; // Heap property is satisfied
            } else {
                swapValues(current, smallerChild);
                current = smallerChild; // Move down to the child
            }
        }
    }

    /**
     * Finds the node at a given 1-based index in the complete binary tree.
     * The path is determined by the binary representation of the index.
     * @param index The 1-based index of the node.
     * @return The node at the specified index.
     */
    private Node getNode(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        if (index == 1) {
            return root;
        }

        // Traverse using the binary representation of the index, skipping the MSB.
        String path = Integer.toBinaryString(index);
        Node current = root;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    /**
     * Swaps the values of two nodes.
     * @param n1 The first node.
     * @param n2 The second node.
     */
    private void swapValues(Node n1, Node n2) {
        int temp = n1.value;
        n1.value = n2.value;
        n2.value = temp;
    }
}