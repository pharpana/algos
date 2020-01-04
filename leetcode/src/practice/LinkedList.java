package practice;

public class LinkedList {
    ListNode head;

    public void add(int val) {
        ListNode node = new ListNode(val);

        if(head == null){
            head = node;
            return;
        }

        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }

        temp.next = node;
    }

    public void traverse(){
        ListNode temp = head;
        StringBuilder sb = new StringBuilder();
        while(temp!=null){
            sb.append(temp.val);
            sb.append("->");
            temp = temp.next;
        }

        System.out.println(sb.toString().isEmpty() ? "" : sb.toString().substring(0, sb.length()-2));
    }

    public void reverse(){
        if(head == null || head.next == null) return;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void reverse(int m, int n) {
        if(head == null || head.next == null) return;

        ListNode prev = null;
        ListNode curr = head;
        while(m>1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode anchor = prev;
        ListNode tail = curr;
        ListNode next = null;
        while(n>0 && curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }

        if(anchor != null){
            anchor.next = prev;
        } else {
            head = prev;
        }

        tail.next = curr;
    }

    public static void main(String[] args){
        LinkedList llist = new LinkedList();
        llist.add(1);
        llist.add(2);
        llist.add(3);
        llist.add(4);
        llist.traverse();

        llist.reverse();
        llist.traverse();

        llist.reverse(1,4);
        llist.traverse();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode (int val) {
        this.val = val;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[val: ");
        sb.append(val);
        sb.append(" , Next: ");
        sb.append(next);
        sb.append("]");
        return sb.toString();
    }
}
