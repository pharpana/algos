package problems;

import java.util.Deque;
import java.util.LinkedList;


/*

362. Design Hit Counter

Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301);
Follow up:
What if the number of hits per second could be very large? Does your design scale?

 */
public class Problem362 {

    Deque<Node> queue;
    int hits;

    /** Initialize your data structure here. */
    public Problem362() {
        queue = new LinkedList<>();
        this.hits = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!queue.isEmpty() && queue.getLast().timestamp == timestamp){
            queue.getLast().hit = queue.getLast().hit+1;
            this.hits++;
        } else {
            queue.addLast(new Node(timestamp,1));
            this.hits++;

            while(!queue.isEmpty() && queue.getFirst().timestamp <= timestamp-300){
                this.hits -= queue.getFirst().hit;
                queue.removeFirst();
            }
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && queue.getFirst().timestamp <= timestamp-300){
            this.hits -= queue.getFirst().hit;
            queue.removeFirst();
        }

        return this.hits;
    }

    static class Node {
        int timestamp;
        int hit;

        Node(int timestamp, int hit) {
            this.timestamp = timestamp;
            this.hit = hit;
        }
    }
}
