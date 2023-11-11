public class ListNode {
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
