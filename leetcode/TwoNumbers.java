import java.math.BigInteger;

public class TwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\nHello!");

        TwoNumbers tn = new TwoNumbers();

        ListNode aA = tn.new ListNode(3);
        ListNode bA = tn.new ListNode(4, aA);
        ListNode cA = tn.new ListNode(2, bA);

        ListNode aB = tn.new ListNode(4);
        ListNode bB = tn.new ListNode(6, aB);
        ListNode cB = tn.new ListNode(5, bB);

        ListNode answer = tn.addTwoNumbers(cA, cB);

        // print ordered output
        String aString = "";
        while(answer.next != null){
            aString = String.valueOf(answer.val) + aString;
            answer = answer.next;
        }
        aString = String.valueOf(answer.val) + aString;
        System.out.println(aString);
    }
    
    private ListNode addTwoNumbers (ListNode a, ListNode b) {
        ListNode ln = new ListNode(); 
        
        // convert list a to ordered string
        String aString = "";
        ln = a;
        while(ln.next != null){
            aString = String.valueOf(ln.val) + aString;
            ln = ln.next;
        }
        aString = String.valueOf(ln.val) + aString;
        
        // convert list b to ordered string
        String bString = "";
        ln = b;
        while(ln.next != null){
            bString = String.valueOf(ln.val) + bString;
            ln = ln.next;
        }
        bString = String.valueOf(ln.val) + bString;

        System.out.print(aString + " + " + bString + " = ");
        
        // convert ordered strings to numbers and find sum
        BigInteger numA = new BigInteger(aString);
        BigInteger numB = new BigInteger(bString);
        BigInteger numC = numA.add(numB);
        
        // convert sum to list
        String sumString = String.valueOf(numC);
        ListNode tail = new ListNode(Character.getNumericValue(sumString.charAt(0)));
        ListNode next = tail;
        for(int i = 1; i<sumString.length(); i++){
            char c = sumString.charAt(i);
            int num = Character.getNumericValue(c);
            ListNode curr = new ListNode(num, next);
            next = curr;
        }

        ln = next;
        return ln;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
