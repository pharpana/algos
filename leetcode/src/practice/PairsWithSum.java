package practice;

import java.util.*;

public class PairsWithSum {

    public List<List<Integer>> getPairs(int[] arr, int target) {

        if(arr == null || arr.length ==0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> unPairedMap = new HashMap<>();
        Arrays.stream(arr).forEach(t -> {
            int diff = target-t;
            int diffVal = unPairedMap.getOrDefault(diff,0);
            if(diffVal>=1){
                result.add(Arrays.asList(t, diff));
                unPairedMap.put(diff, diffVal-1);
            } else {
                unPairedMap.put(t, unPairedMap.getOrDefault(t,0)+1);
            }
        });

        return result;
    }

    public static void main(String[] args){
        PairsWithSum pairsWithSum = new PairsWithSum();
        System.out.println(pairsWithSum.getPairs(new int[]{1,2,3,4,5,6,7,8},10));
        System.out.println(pairsWithSum.getPairs(new int[]{8,7,4,4,5,6,7,8},12));
    }
}
