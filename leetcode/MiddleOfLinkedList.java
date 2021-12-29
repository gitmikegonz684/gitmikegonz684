/**
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * If there are two middle nodes, return the second middle node.
 * 
 * EXAMPLE 1
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * 
 * EXAMPLE 2
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we
 * return the second one.
 */

public class MiddleOfLinkedList {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class SinglyLinkedList {
        public ListNode head = null;
        public ListNode tail = null;

        public SinglyLinkedList() {
        }

        public void addNode(int value) {
            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public void displayList() {
            ListNode current = head;
            if (head == null) {
                System.out.println("List is empty");
            } else {
                System.out.print("The linked list: ");
                while (current != null) {
                    System.out.print(current.val + " ");
                    current = current.next;
                }
            }
        }
    }

    public ListNode middleNode(ListNode head) {
        int count = 1;
        int middleNode = 0;
        boolean hasNext = true;
        ListNode pointer = head;
        // find middle node
        while (hasNext) {
            if (pointer.next != null) {
                count = count + 1;
            } else {
                hasNext = false;
            }
            pointer = pointer.next;
        }
        middleNode = (count / 2) + 1;

        // Navigate to middle node
        pointer = head;
        for (int i = 1; i < middleNode; i++) {
            pointer = pointer.next;
        }

        // Return middle node
        return pointer;
    }

    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4, 5 };

        // Create the list
        MiddleOfLinkedList test = new MiddleOfLinkedList();
        SinglyLinkedList list = test.new SinglyLinkedList();
        for (int val : values) {
            list.addNode(val);
        }
        list.displayList();

        // Return the middle node
        System.out.print("\nThe middle node: ");
        System.out.println(test.middleNode(list.head).val);
    }
}
