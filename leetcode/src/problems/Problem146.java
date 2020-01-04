package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem146 {

        ListNode head;
        ListNode tail;
        Map<Integer, ListNode> cache;
        int capacity;
        int size;

        class ListNode {
            int key;
            int val;
            ListNode prev;
            ListNode next;
        }

        public Problem146(int capacity) {
            cache = new HashMap<>();
            this.capacity = capacity;
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead(ListNode node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        public void moveToHead(ListNode node) {
            remove(node);
            addToHead(node);
        }

        public void remove(ListNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            ListNode node = cache.get(key);
            moveToHead(node);

            return node.val;
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                ListNode node = cache.get(key);
                node.val = value;
                moveToHead(node);
            } else {
                if(size == capacity){
                    ListNode lruNode = tail.prev;
                    remove(lruNode);
                    cache.remove(lruNode.key);
                    size--;
                }
                ListNode node = new ListNode();
                node.key = key;
                node.val = value;
                addToHead(node);
                cache.put(key, node);
                size++;
            }
        }


        public static void main(String[] args) {
            Problem146 problem = new Problem146(5);
            problem.put(1,10);
            problem.put(2,20);
            problem.put(3,30);
            problem.put(4,40);
            problem.put(5,50);
            System.out.println(problem.get(5));
            System.out.println(problem.get(3));
            System.out.println(problem.get(2));
            System.out.println(problem.get(4));
            problem.put(6,60);
            System.out.println(problem.get(1)); // -1
        }
}
