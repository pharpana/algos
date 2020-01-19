package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/*
57. Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 */

public class Problem57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals == null || intervals.length==0) return new int[][]{newInterval};
        if(newInterval == null || newInterval.length == 0) return intervals;

        LinkedList<int[]> queue = new LinkedList<>();

        for(int[] pair : intervals){
            queue.add(pair);
        }

        List<int[]> result = new ArrayList<>();
        boolean done = false;

        while(!done && !queue.isEmpty()){
            if(newInterval[1]<queue.peek()[0]){
                result.add(newInterval);
                done = true;
                continue;
            }

            if(newInterval[0] > queue.peek()[1]){
                result.add(queue.poll());
            } else {
                int[] nums = queue.poll();
                newInterval[0] = Math.min(nums[0], newInterval[0]);
                newInterval[1] = Math.max(nums[1], newInterval[1]);
            }

            if(queue.isEmpty()){
                result.add(newInterval);
            }

        }

        while(!queue.isEmpty()){
            result.add(queue.poll());
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args){
        Problem57 problem57 = new Problem57();
        Stream.of(problem57.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})).forEach(t -> Stream.of(t).forEach(i -> System.out.println("[" + i[0] + "," + i[1] + "]")));
        Stream.of(problem57.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})).forEach(t -> Stream.of(t).forEach(i -> System.out.println("[" + i[0] + "," + i[1] + "]")));
    }
}
