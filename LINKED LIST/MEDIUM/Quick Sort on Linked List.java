class Solution{
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode end) {
        if (head == null || head == end || head.next == end) {
            return head;
        }

        ListNode pivot = partition(head, end);
        quickSort(head, pivot);
        quickSort(pivot.next, end);

        return head;
    }

    private ListNode partition(ListNode head, ListNode end) {
        int pivotValue = head.val;
        ListNode pivot = head;
        ListNode current = head.next;

        while (current != end) {
            if (current.val < pivotValue) {
                pivot = pivot.next;
                int temp = pivot.val;
                pivot.val = current.val;
                current.val = temp;
            }
            current = current.next;
        }

        int temp = pivot.val;
        pivot.val = head.val;
        head.val = temp;

        return pivot;
    }
}