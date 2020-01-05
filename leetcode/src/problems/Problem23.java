package problems;

/*
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class Problem23 {

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val-l2.val);

        for(ListNode node : lists){
            if(node!=null)
                pq.offer(node);
        }

        ListNode res = new ListNode(-1);
        ListNode temp = res;

        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            temp.next = n;
            temp = temp.next;

            if(n.next != null) {
                pq.offer(n.next);
            }
        }

        return res.next;
    }

}
