package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution35 {

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();

        //int result = solution35.searchInsert(nums, 7);
        //System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        int existsIdx = Arrays.binarySearch(nums, target);

        if(existsIdx > -1) {
            return existsIdx;
        }

        List<Integer> numsCollect = Arrays.stream(nums).boxed()
                .collect(Collectors.toList());

        numsCollect.add(target);
        Collections.sort(numsCollect);
        return Collections.binarySearch(numsCollect, target);

    }
}
