package problems;

/*
4. Median of 2 sorted arrays
 */
public class Problem4 {

    public double findMedian(int[] nums1, int[] nums2){

        if(nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while(low<=high) {

            int partitionX = low + (high-low)/2;
            int partitionY = (x+y+1)/2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x+y)%2 == 0){
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY) {
                high = partitionX-1;
            } else {
                low = partitionX+1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args){
        Problem4 problem = new Problem4();
        int[] nums1 = {1,2,5,7,8};
        int[] nums2 = {3,9,10,11};
        System.out.println(problem.findMedian(nums1, nums2));
    }
}
