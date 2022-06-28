public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists mtl = new MergeTwoLists();
        ListNode aa = mtl.new ListNode(-9);
        aa.next = mtl.new ListNode(3);
        // aa.next.next = mtl.new ListNode(4);
        ListNode ba = mtl.new ListNode(5);
        ba.next = mtl.new ListNode(7);
        // ba.next.next = mtl.new ListNode(4);
        ListNode ca = mtl.mergeTwoLists(aa, ba);
        System.out.println(ca.toString());
    }

    private class ListNode {
        public int val;
        public ListNode next;
    
        public ListNode () {};
    
        public ListNode (int value) {
            val = value;
            next = null;
        }
    
        public ListNode (int value, ListNode nextnode) {
            val = value;
            next = nextnode;
        }
    
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{" + val);
            ListNode temp = next;
            while (temp!=null) {
                sb.append("->" + temp.val);
                temp = temp.next;
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode head = new ListNode();
        ListNode tail = head;
        // check for null input before starting
        if (list1==null) {
            return list2;
        } else if (list2==null) {
            return list1;
        }

        // add the first node
        if (curr1.val<curr2.val) {
            tail.val = curr1.val;
            curr1 = curr1.next;
        } else {
            tail.val = curr2.val;
            curr2 = curr2.next;
        }

        // add the middle nodes
        while (curr1!=null || curr2!=null) {
            tail.next = new ListNode();
            tail = tail.next;
            if (curr1==null) {
                tail.val = curr2.val;
                curr2 = curr2.next;
            } else if (curr2==null) {
                tail.val = curr1.val;
                curr1 = curr1.next;
            } else {
                // add min node to list
                if (curr1.val<curr2.val) {
                    tail.val = curr1.val;
                    curr1 = curr1.next;
                } else {
                    tail.val = curr2.val;
                    curr2 = curr2.next;
                }
            }
        }

        return head;
    }
}
