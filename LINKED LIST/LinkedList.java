class Node {
    int val;     
    Node next;
    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    Node(int val) {
        this.val = val; 
        this.next = null;  
    }
}

public class LinkedList {
    private Node head;

    public void insertAtPosition(int position, int value) {
        Node newNode = new Node(value);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        if (position < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        if (position < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }
        Node current = head;
        for (int i = 0; i < position - 1 && current != null && current.next != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        current.next = current.next.next;
    }

    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPosition(0, 2);
        list.insertAtPosition(1, 5);
        list.insertAtPosition(2, 8);
        list.insertAtPosition(3, 7);

        System.out.println("List after insertion:");
        list.printList();

        list.deleteAtPosition(2);
        System.out.println("List after deletion at position 2:");
        list.printList();

        System.out.println("Length of the list: " + list.length());
        System.out.println("Is the list empty? " + list.isEmpty());
    }
}