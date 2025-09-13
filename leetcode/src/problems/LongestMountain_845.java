public class LongestMountain {

  public static void main(String[] args) {
  }

  public static int getLongestMountain(int[] arr) {
    int res = 0; // total length of the longest mountain
    int len = arr.length;
    int base = 0; // left boundary

    while(base < len) {
      int end = base;

      // chekc base can be left boundary
      if(end + 1 < len && arr[end] < arr[end + 1]) {
        // track peak using end
        while(end + 1 < len && arr[end] < arr[end + 1]) {
          end++;
        }
      } // end if

      // use end to track the right boundary
      if(end + 1 < len && arr[end] > arr[end + 1]) {
        while(end + 1 < len && arr[end] > arr[end + 1]) {
          end++;
        }
        res = Math.max(res, end - base + 1);
      }
      base = Math.max(base + 1, end);
    } // end while 

    return res;
  }
}
