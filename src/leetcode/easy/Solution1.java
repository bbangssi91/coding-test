package leetcode.easy;

import java.util.Hashtable;
import java.util.stream.IntStream;

/**
 *  두개의 합
 *
 *  https://leetcode.com/problems/two-sum/description/
 *
 *  - 2중 for문일 경우, O(N^2) 으로 성능이 떨어지므로, HashTable에 값과 인덱스를 저장해두고,
 *
 *  Target = A + B >> Target - A = B 성질을 이용하여, O(N) 으로 문제해결
 *
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solve = new Solution1();

        int[] ints = solve.twoSum(new int[]{2, 7, 11, 15}, 9);
        IntStream.of(ints).forEach(o -> System.out.println(o));
    }

    public int[] twoSum(int[] nums, int target) {

        /**
         *  key값에 값, value에 index정보를 넣는다.
         *
         */
        Hashtable<Integer, Integer> sumTable = new Hashtable<>();
        int [] num = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            sumTable.put(nums[i], i);
        }

        for(int j = 0; j < nums.length; j++) {

            Integer remainder = sumTable.get(target - nums[j]);
            if(remainder != null && remainder != j) {
                return new int[]{j, remainder};
            }


        }

        return null;
    }
}
