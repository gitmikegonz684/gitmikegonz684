public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode reversed = rll.reverseList(list);
        System.out.println(reversed.toString());
    }

    /**
     * REVERSE LIST
     * Uses recursion & pointers to reverse the order of nodes in a linked list
     * 
     * @param head the head of the list to be reversed
     * @return the head ListNode of the new reversed list.
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            return null;
        }
        if (head.next==null) {
            return new ListNode(head.val);
        } else {
            ListNode reversedHead = reverseList(head.next);
            ListNode newNext = new ListNode(head.val);
            ListNode currNext = reversedHead.next;
            Boolean hasNext;
            if (currNext!=null) {
                hasNext = true;
            } else {
                reversedHead.next = newNext;
                hasNext = false;
            }
            while (hasNext) {
                if (currNext.next==null) {
                    currNext.next = newNext;
                    hasNext = false;
                } else {
                    currNext = currNext.next;
                }
            }
            return reversedHead;
        }
    }
}
